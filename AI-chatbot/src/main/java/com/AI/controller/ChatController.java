package com.AI.controller;

import com.AI.dto.ChatRequest;
import com.AI.dto.ChatResponse;
import com.AI.service.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/chat")
public class ChatController {

    private final ChatService chatService;

    // Constructor Injection
    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    @PostMapping
    public ChatResponse askQuestion(
            @RequestBody ChatRequest request) {

        String answer =
                chatService.askAI(
                        request.getMessage());

        return new ChatResponse(answer);
    }
}