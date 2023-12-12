package com.lisandro.quiz.controller;

import com.lisandro.quiz.entity.Question;
import com.lisandro.quiz.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {
    @Autowired
    QuestionService questionService;

    @GetMapping()
    public List<Question> getQuestions() {
        return questionService.getQuestions();
    }
}
