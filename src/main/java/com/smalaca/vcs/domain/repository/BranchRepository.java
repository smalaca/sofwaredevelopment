package com.smalaca.vcs.domain.repository;

import com.smalaca.vcs.domain.model.Branch;

public interface BranchRepository {
    Branch getMasterBranch();
}
