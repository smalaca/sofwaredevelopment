package com.smalaca.vcs.domain.model;

public interface History {
    void store(String message, CodeDelta codeDelta, Author author, ChangeDate date);
}
