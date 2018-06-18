package com.smalaca.vcs.domain.service;

import com.smalaca.vcs.domain.exception.ManualMergeForbidden;
import com.smalaca.vcs.domain.model.Author;
import com.smalaca.vcs.domain.model.AuthorId;
import com.smalaca.vcs.domain.model.Branch;
import com.smalaca.vcs.domain.model.BuildsHistory;
import com.smalaca.vcs.domain.repository.AuthorRepository;
import com.smalaca.vcs.domain.repository.Branches;
import com.smalaca.vcs.domain.repository.BuildsHistoryRepository;

public class MasterBranchService {
    private final Branches branches;
    private final BuildsHistoryRepository buildsHistoryRepository;
    private final AuthorRepository authorRepository;

    public MasterBranchService(Branches branches, BuildsHistoryRepository buildsHistoryRepository, AuthorRepository authorRepository) {
        this.branches = branches;
        this.buildsHistoryRepository = buildsHistoryRepository;
        this.authorRepository = authorRepository;
    }

    public void fixWith(Branch branch, AuthorId authorId) {
        Author author = authorRepository.findBy(authorId);

        if (author.cannotMergeToMaster()) {
            throw new ManualMergeForbidden(author);
        }

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