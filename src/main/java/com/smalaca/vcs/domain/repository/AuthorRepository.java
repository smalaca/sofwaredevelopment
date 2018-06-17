package com.smalaca.vcs.domain.repository;

import com.smalaca.vcs.domain.model.Author;
import com.smalaca.vcs.domain.model.AuthorId;

public interface AuthorRepository {
    Author findBy(AuthorId authorId);
}
