package com.smalaca.vcs.domain.model;

public class Commit {
    private final String message;

    Commit(String message) {
        this.message = message;
    }

    String message() {
        return message;
    }
}
