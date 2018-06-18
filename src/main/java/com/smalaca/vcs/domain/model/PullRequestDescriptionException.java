package com.smalaca.vcs.domain.model;

class PullRequestDescriptionException extends RuntimeException {

    private PullRequestDescriptionException(String message) {
        super(message);
    }

    public static RuntimeException noDescription() {
        return new PullRequestDescriptionException("Description cannot be null or empty.");
    }

    public static RuntimeException sameDescription() {
        return new PullRequestDescriptionException("Description cannot be the same as existing.");
    }
}
