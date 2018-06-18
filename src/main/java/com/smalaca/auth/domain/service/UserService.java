package com.smalaca.auth.domain.service;

import com.smalaca.auth.domain.model.User;
import com.smalaca.auth.domain.model.UserId;
import com.smalaca.auth.domain.repository.UserRepository;
import com.smalaca.cipher.Cipher;

public class UserService {
    private final UserRepository userRepository;
    private final Cipher cipher;

    public UserService(UserRepository userRepository, Cipher cipher) {
        this.userRepository = userRepository;
        this.cipher = cipher;
    }

    public void change(String password, UserId userId) {
        String encrypted = cipher.encrypt(password);
        User user = userRepository.findBy(userId);

        user.getCredentials().changePassword(password);

        userRepository.save(user);
    }
}
