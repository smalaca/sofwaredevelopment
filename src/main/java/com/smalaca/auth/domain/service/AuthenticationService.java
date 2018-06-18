package com.smalaca.auth.domain.service;

import com.smalaca.auth.domain.model.User;
import com.smalaca.auth.domain.model.UserId;
import com.smalaca.auth.domain.repository.UserRepository;

import java.util.Map;

public class AuthenticationService {
    private final UserRepository userRepository;

    public AuthenticationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void add(String question, String answer, UserId userId) {
        User user = userRepository.findBy(userId);

        user.add(question, answer);

        userRepository.save(user);
    }

    public Map<String, String> questionsFor(UserId userId) {
        return userRepository.findBy(userId).questions();
    }
}
