package com.smalaca.vcs.domain.repository;

import com.smalaca.vcs.domain.model.PullRequest;

import java.util.List;

public interface PullRequestRepository {
    List<PullRequest> findOpened();
}
