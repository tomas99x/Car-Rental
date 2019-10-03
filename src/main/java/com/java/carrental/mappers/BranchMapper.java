package com.java.carrental.mappers;

import com.java.carrental.dto.BranchDTO;
import com.java.carrental.entity.BranchEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BranchMapper {

    BranchDTO branchToBranchDTO(BranchEntity branchEntity);

    BranchEntity branchDtoToBranch(BranchDTO branchDTO);

    List<BranchDTO> listBranchToBranchDTOS(List<BranchEntity> branchEntity);

    List<BranchEntity> listBranchDTOsToBranch(List<BranchDTO> branchDTO);
}
