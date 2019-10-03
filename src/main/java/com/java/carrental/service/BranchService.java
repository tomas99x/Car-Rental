package com.java.carrental.service;


import com.java.carrental.dto.BranchDTO;

import java.util.List;

public interface BranchService {

    List<BranchDTO> findAllBranches();

    BranchDTO findById(Long id);
}
