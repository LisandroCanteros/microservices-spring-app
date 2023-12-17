package com.lisandro.quiz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class UserService {
    @Autowired
    WebClient.Builder webClient;
    public ResponseEntity<String> getAllUsers() {
        // return webClient.build().get().uri("/todos").retrieve().bodyToFlux(User.class).collectList().block();
        ResponseEntity<String> response = webClient.build().get().uri("/todos").retrieve().toEntity(String.class).block();
        HttpStatusCode status = response.getStatusCode();
        HttpHeaders headers = response.getHeaders();
        String responseBody = response.getBody().toString();

        return response;
    }
}
