package com.smalaca.vcs.domain.service;

import com.smalaca.vcs.domain.model.Branch;
import com.smalaca.vcs.domain.model.BuildsHistory;
import com.smalaca.vcs.domain.model.ResetType;
import com.smalaca.vcs.domain.repository.Branches;
import com.smalaca.vcs.domain.repository.BuildsHistoryRepository;

public class MasterBranchService {
    private final Branches branches;
    private final BuildsHistoryRepository buildsHistoryRepository;

    public MasterBranchService(Branches branches, BuildsHistoryRepository buildsHistoryRepository) {
        this.branches = branches;
        this.buildsHistoryRepository = buildsHistoryRepository;
    }

    public void fix() {
        Branch master = branches.aMasterBranch();
        BuildsHistory buildsHistory = buildsHistoryRepository.findFor(master);

        if (buildsHistory.current().failed() && buildsHistory.prev().succeed()) {
            master.reset(ResetType.HARD, 1);
            triggerMasterPipeLine();
        }
    }

    private void triggerMasterPipeLine() {

    }
}
