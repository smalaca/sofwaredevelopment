package com.smalaca.auth.domain.model;

public class Credentials {
    private String login;
    private String password;

    Credentials(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public void changePassword(String password) {
        this.password = password;
    }
}
