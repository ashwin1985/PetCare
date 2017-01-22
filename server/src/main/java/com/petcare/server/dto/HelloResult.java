package com.petcare.server.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class HelloResult {

    private String message;

    public HelloResult() {}

    public HelloResult(String message) {
        this.message = message;
    }

    @JsonProperty("message")
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
