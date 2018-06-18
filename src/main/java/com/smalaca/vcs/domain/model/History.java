package com.smalaca.vcs.domain.model;

import java.util.Map;

public interface History {
    void store(String message, CodeDelta codeDelta, Author author, ChangeDate date);

    void store(String message, String description, CodeDelta codeDelta, Author author, ChangeDate date);

    void store(Map<String, CodeDelta> persistables, Author author, ChangeDate date);
}
