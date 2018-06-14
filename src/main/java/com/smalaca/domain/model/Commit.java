package com.smalaca.domain.model;

public class Commit {
    private final String message;

    Commit(String message) {
        this.message = message;
    }

    String message() {
        return message;
    }
}
