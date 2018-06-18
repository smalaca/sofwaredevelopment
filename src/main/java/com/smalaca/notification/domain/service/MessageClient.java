package com.smalaca.notification.domain.service;

import com.smalaca.vcs.domain.model.PullRequest;

public interface MessageClient {
    void notifyAbout(PullRequest pullRequest);
}
