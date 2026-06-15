package com.AI.service;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.Map;

@Service
public class ChatService {

    private final WebClient webClient;

    @Value("${openrouter.api.key}")
    private String apiKey;

    @Value("${openrouter.api.url}")
    private String apiUrl;

    public ChatService(WebClient webClient) {
        this.webClient = webClient;
    }

    public String askAI(String userMessage) {

        Map<String, Object> requestBody = Map.of(
                "model", "openai/gpt-4o-mini",
                "messages", List.of(
                        Map.of(
                                "role", "user",
                                "content", userMessage
                        )
                )
        );

        try {

            String response = webClient.post()
                    .uri(apiUrl)
                    .header(HttpHeaders.AUTHORIZATION,
                            "Bearer " + apiKey)
                    .header(HttpHeaders.CONTENT_TYPE,
                            MediaType.APPLICATION_JSON_VALUE)
                    .bodyValue(requestBody)
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();

            return response;

        } catch (Exception e) {

            e.printStackTrace();

            return "Error : " + e.getMessage();
        }
    }
}