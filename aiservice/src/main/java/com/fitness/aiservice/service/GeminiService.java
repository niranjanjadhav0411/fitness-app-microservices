package com.fitness.aiservice.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.loadbalancer.reactive.WebClientCustomizer;

public class GeminiService {

    private final WebClientCustomizer webClient;

    @Value("${gemini.api.url}")
    private String geminiApiUrl;

    @Value("${gemini.api.key}")
    private String geminiApiKey;

    public GeminiService(WebClientCustomizer.Builder webClientBuilder) {
        this.webClient = webClientBuilder.build();
    }
}
