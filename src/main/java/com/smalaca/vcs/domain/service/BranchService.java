package com.smalaca.vcs.domain.service;

import com.smalaca.clock.Clock;
import com.smalaca.vcs.domain.model.Author;
import com.smalaca.vcs.domain.model.AuthorId;
import com.smalaca.vcs.domain.model.ChangeDate;
import com.smalaca.vcs.domain.model.CodeDelta;
import com.smalaca.vcs.domain.model.History;
import com.smalaca.vcs.domain.repository.AuthorRepository;

public class BranchService {
    private final History history;
    private final AuthorRepository authorRepository;
    private final Clock clock;

    public BranchService(History history, AuthorRepository authorRepository, Clock clock) {
        this.history = history;
        this.authorRepository = authorRepository;
        this.clock = clock;
    }

    void merge(String message, String description, CodeDelta codeDelta, AuthorId authorId) {
        Author author = authorRepository.findBy(authorId);
        ChangeDate changeDate = new ChangeDate(clock.nowDate());

        history.store(message, description, codeDelta, author, changeDate);
    }
}
