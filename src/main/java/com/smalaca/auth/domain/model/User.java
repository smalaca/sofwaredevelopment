package com.smalaca.auth.domain.model;

import java.util.HashMap;
import java.util.Map;

public class User {
    private final Map<String, String> questions = new HashMap<>();

    public void add(String question, String answer) {
        questions.put(question, answer);
    }

    public Map<String, String> questions() {
        return questions;
    }
}
