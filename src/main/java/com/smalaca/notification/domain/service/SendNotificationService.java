package com.smalaca.notification.domain.service;

import com.smalaca.vcs.domain.model.PullRequest;
import com.smalaca.vcs.domain.model.PullRequestState;
import com.smalaca.vcs.domain.repository.PullRequestRepository;

import java.util.List;

public class SendNotificationService {
    private final MessageClient messageClient;
    private final PullRequestRepository pullRequestRepository;

    public SendNotificationService(MessageClient messageClient, PullRequestRepository pullRequestRepository) {
        this.messageClient = messageClient;
        this.pullRequestRepository = pullRequestRepository;
    }

    public void send() {
        List<PullRequest> pullRequests = pullRequestRepository.findOpened();

        for (PullRequest pullRequest : pullRequests) {
            if (pullRequest.getState() != PullRequestState.APPROVED) {
                messageClient.notifyAbout(pullRequest);
            }
        }
    }
}
