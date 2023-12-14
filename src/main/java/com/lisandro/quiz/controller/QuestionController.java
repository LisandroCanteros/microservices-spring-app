package com.lisandro.quiz.controller;

import com.lisandro.quiz.dto.User;
import com.lisandro.quiz.entity.Question;
import com.lisandro.quiz.service.QuestionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("question")
public class QuestionController {
    @Autowired
    QuestionService questionService;

    @GetMapping()
    public List<Question> getQuestions() {
        return questionService.getQuestions();
    }

    @GetMapping("/{id}")
    public Optional<Question> getQuestion(@PathVariable int id){
        return questionService.getQuestion(id);
    }

    @GetMapping("/category/{category}")
    public List<Question> getQuestionsByCategory(@PathVariable String category) {
        return questionService.getQuestionsByCategory(category);
    }

    @PostMapping
    public ResponseEntity<String> addQuestion(@Valid @RequestBody Question question, BindingResult bindingResult) {
        // validate body
        if (bindingResult.hasErrors()) {
            List<String> errors = bindingResult.getFieldErrors()
                    .stream()
                    .map(error -> error.getField() + ": " + error.getDefaultMessage())
                    .toList();
            return ResponseEntity.badRequest().body("Validation failed. Errors: " + errors);
        }

        String serviceResponse = questionService.addQuestion(question);
        // check if insert was successful
        if (serviceResponse.equals("Success")) {
            return ResponseEntity.ok("User created successfully");
        }

        return ResponseEntity.internalServerError().body("Error inserting value into database.");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteQuestion(@PathVariable int id) {
        String serviceResponse = questionService.deleteQuestion(id);
        if (serviceResponse.equals("Success")) {
            return ResponseEntity.ok("Question with id " + id + " deleted.");
        }
        return ResponseEntity.internalServerError().body("Error deleting the question.");
    }
}

