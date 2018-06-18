package com.smalaca.vcs.domain.service;

import com.smalaca.vcs.domain.model.Branch;
import com.smalaca.vcs.domain.model.Build;
import com.smalaca.vcs.domain.repository.BranchRepository;
import com.smalaca.vcs.domain.repository.BuildRepository;

import java.util.function.Predicate;

public class HasNoConfilctsAndHaveGreenBuilds implements Predicate<Branch> {
    private final BranchRepository branchRepository;
    private final BuildRepository buildRepository;

    public HasNoConfilctsAndHaveGreenBuilds(BranchRepository branchRepository, BuildRepository buildRepository) {
        this.branchRepository = branchRepository;
        this.buildRepository = buildRepository;
    }

    @Override
    public boolean test(Branch branch) {
        Branch master = branchRepository.getMasterBranch();
        Build build = buildRepository.buildFor(branch);
        return master.hasConflictsWith(branch) && build.succeed();
    }
}
