package com.lisandro.quiz.service;

import com.lisandro.quiz.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
public class UserService {
    @Autowired
    WebClient.Builder webClient;
    public List<User> getAllUsers() {
        return webClient.build().get().uri("/todos").retrieve().bodyToFlux(User.class).collectList().block();
    }
}
