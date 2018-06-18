package com.smalaca.vcs.domain.service;

import com.smalaca.vcs.domain.model.Branch;
import com.smalaca.vcs.domain.model.BuildsHistory;
import com.smalaca.vcs.domain.repository.Branches;
import com.smalaca.vcs.domain.repository.BuildsHistoryRepository;

public class BuildsAutomaticAction {
    private final Branches branches;
    private final BuildsHistoryRepository buildsHistoryRepository;

    public BuildsAutomaticAction(Branches branches, BuildsHistoryRepository buildsHistoryRepository) {
        this.branches = branches;
        this.buildsHistoryRepository = buildsHistoryRepository;
    }

    public void triggerMergeFor(Branch branch) {
        Branch master = branches.aMasterBranch();
        BuildsHistory masterHistory = buildsHistoryRepository.findFor(master);
        BuildsHistory branchHistory = buildsHistoryRepository.findFor(branch);

        if (masterHistory.failed() && branchHistory.succeed()) {
            master.merge(branch);
            triggerMasterPipeLine();
        }
    }

    private void triggerMasterPipeLine() {

    }
}
