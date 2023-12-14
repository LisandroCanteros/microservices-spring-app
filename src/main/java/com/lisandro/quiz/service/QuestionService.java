package com.lisandro.quiz.service;

import com.lisandro.quiz.dto.User;
import com.lisandro.quiz.repository.QuestionRepository;
import com.lisandro.quiz.entity.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {
    @Autowired
    QuestionRepository QuestionRepository;

    public List<Question> getQuestions() {
        return QuestionRepository.findAll();
    }

    public Optional<Question> getQuestion(int id) {
        return QuestionRepository.findById(id);
    }

    public List<Question> getQuestionsByCategory(String category) {
        return QuestionRepository.findAllByCategory(category);
    }

    public String addQuestion(Question question) {
        try {
            QuestionRepository.save(question);
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
        return "Success";
    }

    public String deleteQuestion(int id) {
        try {
            QuestionRepository.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
        return "Success";
    }
}
