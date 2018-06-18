package com.smalaca.auth.domain.service;

import com.smalaca.auth.domain.model.Role;
import com.smalaca.auth.domain.model.User;
import com.smalaca.auth.domain.model.UserId;
import com.smalaca.auth.domain.repository.UserRepository;

public class AuthorizationService {
    private final UserRepository userRepository;

    public AuthorizationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean hasAccessToAdministrationResources(UserId userId) {
        User user = userRepository.findBy(userId);

        for (Role role : user.roles()) {
            if (role == Role.ADMIN) {
                return true;
            }
        }

        return false;
    }
}
