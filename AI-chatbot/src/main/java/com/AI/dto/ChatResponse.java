package com.AI.dto;

public class ChatResponse {

    private String answer;

    // No-Argument Constructor
    public ChatResponse() {
    }

    // All-Argument Constructor
    public ChatResponse(String answer) {
        this.answer = answer;
    }

    // Getter
    public String getAnswer() {
        return answer;
    }

    // Setter
    public void setAnswer(String answer) {
        this.answer = answer;
    }

    // toString()
    @Override
    public String toString() {
        return "ChatResponse{" +
                "answer='" + answer + '\'' +
                '}';
    }

    // hashCode()
    @Override
    public int hashCode() {
        return answer != null ? answer.hashCode() : 0;
    }

    // equals()
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof ChatResponse)) {
            return false;
        }

        ChatResponse other = (ChatResponse) obj;

        if (answer == null) {
            return other.answer == null;
        }

        return answer.equals(other.answer);
    }
}
