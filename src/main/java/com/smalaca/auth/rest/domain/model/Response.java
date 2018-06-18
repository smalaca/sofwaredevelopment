package com.smalaca.auth.rest.domain.model;

import java.util.Map;

public class Response {
    private final HttpStatus httpStatus;
    private final Object response;

    private Response(HttpStatus httpStatus, Object response) {
        this.httpStatus = httpStatus;
        this.response = response;
    }

    public static Response ok(Map<String, String> questions) {
        return new Response(HttpStatus.OK, questions);
    }
}
