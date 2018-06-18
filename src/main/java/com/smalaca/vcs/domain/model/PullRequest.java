package com.smalaca.vcs.domain.model;

import java.util.ArrayList;
import java.util.List;

public class PullRequest {
    private final List<Commit> commits = new ArrayList<>();
    private final String name;
    private String description;

    public PullRequest(String name) {
        this.name = name;
    }

    public void add(String description) {
        if (description == null) {
            throw PullRequestDescriptionException.noDescription();
        }
        if (this.description.equals(description)) {
            throw PullRequestDescriptionException.sameDescription();
        }

        this.description = description;
    }

    public void add(Commit commit) {
        if (commit.requiresActivity()) {
            requiresApproval();
        }

        commits.add(commit);
    }

    private void requiresApproval() {

    }
}
