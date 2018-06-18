package com.smalaca.auth.rest.api;

import com.smalaca.auth.domain.model.UserId;
import com.smalaca.auth.domain.service.AuthenticationService;
import com.smalaca.auth.rest.domain.model.Response;

import java.util.Map;

public class AuthenticationController {
    private final AuthenticationService authenticationService;

    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    public Response displayAllQuestions(UserId userId) {
        Map<String, String> questions = authenticationService.questionsFor(userId);

        return Response.ok(questions);
    }
}
