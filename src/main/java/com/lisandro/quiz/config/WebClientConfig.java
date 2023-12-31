package com.lisandro.quiz.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    @Value("${jsonplaceholder.base-url}")
    private String baseUrl;

    @Bean(name = "jsonplaceholderAPI")
    public WebClient.Builder webClientBuilder() {
        return WebClient.builder().baseUrl(baseUrl);
    }

}
