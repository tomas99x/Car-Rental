package com.java.carrental.service;

import com.java.carrental.dto.BranchDTO;
import com.java.carrental.dto.EmployeeDTO;

import java.util.List;

public interface EmployeeService {

    List<EmployeeDTO> findAllEmployees();

    EmployeeDTO findEmployeeById(Long id);

    List<EmployeeDTO> findEmployeeByIdS(List<Long> ids);

    EmployeeDTO findEmployeeByIdWithCar(Long id);

    List<EmployeeDTO> findAllEmployeesWithCar();

    List<EmployeeDTO>findEmployeesByBranch(BranchDTO branchDTO);
}
