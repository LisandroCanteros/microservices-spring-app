package com.lisandro.quiz.service;

import com.lisandro.quiz.dao.QuestionDao;
import com.lisandro.quiz.entity.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    @Autowired
    QuestionDao questionDao;
    public List<Question> getQuestions() {
        return questionDao.findAll();
    }
}
