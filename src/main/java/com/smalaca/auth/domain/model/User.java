package com.smalaca.auth.domain.model;

import java.util.ArrayList;
import java.util.List;

public class User {
    private final List<Role> roles = new ArrayList<>();

    public List<Role> roles() {
        return roles;
    }
}
