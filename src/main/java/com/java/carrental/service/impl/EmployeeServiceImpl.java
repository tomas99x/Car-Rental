package com.java.carrental.service.impl;

import com.java.carrental.dto.BranchDTO;
import com.java.carrental.dto.CarDTO;
import com.java.carrental.dto.EmployeeDTO;
import com.java.carrental.entity.BranchEntity;
import com.java.carrental.entity.CarEntity;
import com.java.carrental.entity.EmployeeEntity;
import com.java.carrental.mappers.BranchMapper;
import com.java.carrental.mappers.CarMapper;
import com.java.carrental.mappers.EmployeeMapper;
import com.java.carrental.repository.CarRepository;
import com.java.carrental.repository.EmployeeRepository;
import com.java.carrental.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor(onConstructor = @__(@Autowired))
@Service
public class EmployeeServiceImpl implements EmployeeService {

    private CarMapper carMapper;
    private EmployeeMapper employeeMapper;
    private CarRepository carRepository;
    private EmployeeRepository employeeRepository;
    private BranchMapper branchMapper;


    @Override
    public List<EmployeeDTO> findAllEmployees() {
        List<EmployeeEntity> employeeEntities = employeeRepository.findAll();
        return employeeMapper.listEmployeesToEmployeeDTOs(employeeEntities);
    }

    @Override
    public EmployeeDTO findEmployeeById(Long id) {
        return employeeMapper.employeeToEmployeeDTO(employeeRepository.findById(id).get());
    }

    @Override
    public List<EmployeeDTO> findEmployeeByIdS(List<Long> ids) {
        return employeeMapper.listEmployeesToEmployeeDTOs(employeeRepository.findAllById(ids));
    }

    @Override
    public EmployeeDTO findEmployeeByIdWithCar(Long id) {
        EmployeeEntity employeeEntity = employeeRepository.findById(id).get();
        EmployeeDTO employeeDTO = employeeMapper.employeeToEmployeeDTO(employeeEntity);
        employeeDTO.setCars(carMapper.listCarToCarDTOs(employeeEntity.getCars()));
        return employeeDTO;
    }

    @Override
    public List<EmployeeDTO> findAllEmployeesWithCar() {
        List<EmployeeEntity> employeeEntities = employeeRepository.findAll();
        List<EmployeeDTO> employeeDTO = employeeMapper.listEmployeesToEmployeeDTOs(employeeEntities);
        for (int i = 0; i < employeeDTO.size(); i++ ) {
            if (!employeeEntities.get(i).getCars().isEmpty()) {
                employeeDTO.get(i).setCars(carMapper.listCarToCarDTOs(employeeEntities.get(i).getCars()));
            }
        }
        return employeeDTO;
    }

    @Override
    public List<EmployeeDTO>findEmployeesByBranch(BranchDTO branchDTO){
        BranchEntity branchEntity = branchMapper.branchDtoToBranch(branchDTO);
        return employeeMapper.listEmployeesToEmployeeDTOs(employeeRepository.findEmployeesByBranch(branchEntity));
    }

    @Override
    public EmployeeDTO addEmployee(EmployeeDTO employeeDTO) {
        EmployeeEntity employeeEntity = employeeMapper.employeeDtoToEmployee(employeeDTO);

        if (employeeDTO.getCars() != null) {
            List<CarEntity> carEntities = new ArrayList<>();
            employeeDTO.getCars().removeIf(p-> p.getId() == null);

            for (CarDTO car : employeeDTO.getCars()) {
                if (car.getId() != null){
                    carEntities.add(carRepository.findById(car.getId()).get());
                }
            }
            employeeEntity.setCars(carEntities);
        }

        employeeEntity = employeeRepository.save(employeeEntity);
        return employeeMapper.employeeToEmployeeDTO(employeeEntity);
    }

}
