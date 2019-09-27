package com.java.carrental.service.impl;

import com.java.carrental.dto.EmployeeDTO;
import com.java.carrental.entity.EmployeeEntity;
import com.java.carrental.mappers.CarMapper;
import com.java.carrental.mappers.EmployeeMapper;
import com.java.carrental.repository.CarRepository;
import com.java.carrental.repository.EmployeeRepository;
import com.java.carrental.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor(onConstructor = @__(@Autowired))
@Service
public class EmployeeServiceImpl implements EmployeeService {

    private CarMapper carMapper;
    private EmployeeMapper employeeMapper;
    private CarRepository carRepository;
    private EmployeeRepository employeeRepository;

    @Override
    public List<EmployeeDTO> findAllEmployees() {
        List<EmployeeEntity> setCars = employeeRepository.findAll();
        return employeeMapper.listEmployeesToEmployeeDTOs(setCars);
    }

    @Override
    public EmployeeDTO findEmployeeById(Long id) {
        return employeeMapper.employeeToEmployeeDTO(employeeRepository.findById(id).get());
    }

    @Override
    public EmployeeDTO findEmployeeByIdWithCar(Long id) {
        EmployeeEntity employeeEntity = employeeRepository.findById(id).get();
        EmployeeDTO employeeDTO = employeeMapper.employeeToEmployeeDTO(employeeEntity);
        employeeDTO.setCars(carMapper.listCarToCarDTOs(employeeEntity.getCars()));
        return employeeDTO;
    }
}
