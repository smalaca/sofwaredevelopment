package com.smalaca.vcs.domain.repository;

import com.smalaca.vcs.domain.model.Branch;
import com.smalaca.vcs.domain.model.Build;

public interface BuildRepository {
    Build buildFor(Branch branch);
}
