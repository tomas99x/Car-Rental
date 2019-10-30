package com.java.carrental.service;


import com.java.carrental.dto.BranchDTO;

import java.util.List;

public interface BranchService {

    List<BranchDTO> findAllBranches();

    BranchDTO findBranchById(Long id);

    BranchDTO saveBranch(BranchDTO branchDTO);
}
