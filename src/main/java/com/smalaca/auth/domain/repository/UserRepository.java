package com.smalaca.auth.domain.repository;

import com.smalaca.auth.domain.model.User;
import com.smalaca.auth.domain.model.UserId;

public interface UserRepository {
    User findBy(UserId userId);
}
