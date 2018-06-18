package com.smalaca.vcs.domain.repository;

import com.smalaca.vcs.domain.model.Branch;
import com.smalaca.vcs.domain.model.BuildsHistory;

public interface BuildsHistoryRepository {
    BuildsHistory findFor(Branch branch);
}
