package com.lisandro.quiz.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lisandro.quiz.entity.Question;
import com.lisandro.quiz.entity.Quiz;
import com.lisandro.quiz.repository.QuestionRepository;
import com.lisandro.quiz.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class QuizService {
    @Autowired
    ObjectMapper objectMapper;
    @Autowired
    QuestionRepository questionRepository;
    @Autowired
    QuizRepository quizRepository;

    public ResponseEntity<String> createQuiz(String request) {
        try {
            Map<String, String> map = objectMapper.readValue(request, new TypeReference<Map<String, String>>(){});
            String title = map.getOrDefault("title", null);
            String category = map.getOrDefault("category", null);
            int numberOfQuestions;

            // checking for mandatory fields
            if (title == null) {
                return new ResponseEntity<>("Body must contain 'title'.", HttpStatus.BAD_REQUEST);
            }
            if (category == null) {
                return new ResponseEntity<>("Body must contain 'category'.", HttpStatus.BAD_REQUEST);
            }
            if (map.getOrDefault("number_of_questions", null) == null) {
                return new ResponseEntity<>("Body must contain 'number_of_questions'.", HttpStatus.BAD_REQUEST);
            } else {
                try {
                    numberOfQuestions = Integer.parseInt(map.getOrDefault("number_of_questions", null));
                } catch (Exception e) {
                    e.printStackTrace();
                    return new ResponseEntity<>("'number_of_questions' must be an integer.", HttpStatus.BAD_REQUEST);
                }
            }

            try {
                List<Question> questions = questionRepository.findByCategoryLimit(category, numberOfQuestions);
                if (questions.isEmpty()) {
                    return new ResponseEntity<>("Failed to create quiz: no questions found for this category.", HttpStatus.NOT_FOUND);
                }
                Quiz quiz = new Quiz();
                quiz.setTitle(title);
                quiz.setQuestions(questions);
                quizRepository.save(quiz);
                return new ResponseEntity<>("Quiz created.", HttpStatus.OK);
            } catch (Exception e) {
                e.printStackTrace();
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }


        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
