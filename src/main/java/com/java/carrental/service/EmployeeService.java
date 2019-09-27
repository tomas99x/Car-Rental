package com.java.carrental.service;

import com.java.carrental.dto.EmployeeDTO;

import java.util.List;

public interface EmployeeService {

    List<EmployeeDTO> findAllEmployees();

    EmployeeDTO findEmployeeById(Long id);

    EmployeeDTO findEmployeeByIdWithCar(Long id);
}
