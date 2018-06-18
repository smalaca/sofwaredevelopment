package com.smalaca.vcs.domain.exception;

import com.smalaca.vcs.domain.model.Author;

public class ManualMergeForbidden extends RuntimeException {
    public ManualMergeForbidden(Author author) {
        super("Author " + author.name() + " cannot merge to master.");
    }
}
