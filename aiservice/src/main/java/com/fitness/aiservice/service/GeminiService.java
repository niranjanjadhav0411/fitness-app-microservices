package com.fitness.aiservice.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class GeminiService {
    private final RestClient restClient;

    public GeminiService(RestClient.Builder restClientBuilder) {
        this.restClient = restClientBuilder.build();
    }
}
