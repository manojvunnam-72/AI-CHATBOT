package com.AI.dto;
public class ChatRequest {

	    private String message;

	    // Default Constructor
	    public ChatRequest() {
	    }

	    // Parameterized Constructor
	    public ChatRequest(String message) {
	        this.message = message;
	    }

	    // Getter
	    public String getMessage() {
	        return message;
	    }

	    // Setter
	    public void setMessage(String message) {
	        this.message = message;
	    }
	}

