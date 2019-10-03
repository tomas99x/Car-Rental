package com.java.carrental.service.impl;

import com.java.carrental.dto.BranchDTO;
import com.java.carrental.mappers.BranchMapper;
import com.java.carrental.repository.BranchRepository;
import com.java.carrental.service.BranchService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor(onConstructor = @__(@Autowired))
@Service
public class BranchServiceImpl implements BranchService {

    private BranchRepository branchRepository;
    private BranchMapper branchMapper;

    @Override
    public List<BranchDTO> findAllBranches() {
        return branchMapper.listBranchToBranchDTOS(branchRepository.findAll());
    }

    @Override
    public BranchDTO findById(Long id) {
        return branchMapper.branchToBranchDTO(branchRepository.findById(id).get());
    }
}
