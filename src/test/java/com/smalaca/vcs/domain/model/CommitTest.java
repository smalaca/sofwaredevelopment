package com.smalaca.vcs.domain.model;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CommitTest {
    private static final String CODING_IS_FUN = "Coding is FUN!";

    @Test
    public void firstCommitShouldSayCodingIsFun() {
        Commit commit = new Commit(CODING_IS_FUN);

        assertThat(commit.message()).isEqualTo(CODING_IS_FUN);
    }
}