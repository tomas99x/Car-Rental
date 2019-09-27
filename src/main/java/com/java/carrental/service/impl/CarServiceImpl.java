package com.java.carrental.service.impl;

import com.java.carrental.dto.CarDTO;
import com.java.carrental.dto.EmployeeDTO;
import com.java.carrental.entity.CarEntity;
import com.java.carrental.mappers.CarMapper;
import com.java.carrental.mappers.EmployeeMapper;
import com.java.carrental.repository.CarRepository;
import com.java.carrental.repository.EmployeeRepository;
import com.java.carrental.service.CarService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@AllArgsConstructor(onConstructor = @__(@Autowired))
@Service
public class CarServiceImpl implements CarService {

    private CarMapper carMapper;
    private EmployeeMapper employeeMapper;
    private CarRepository carRepository;
    private EmployeeRepository employeeRepository;

    @Override
    public List<CarDTO> findAllCars() {
        List<CarEntity> setCars = carRepository.findAll();
        return carMapper.listCarToCarDTOs(setCars);
    }

    @Override
    public CarDTO findCarById(Long id) {
        CarEntity carEntity = carRepository.findById(id).get();
        List<EmployeeDTO> employeeDTO = employeeMapper.listEmployeesToEmployeeDTOs(carEntity.getCarKeepers());
        CarDTO carDTO = carMapper.carToCarDTO(carEntity);
        carDTO.setCarKeepers(employeeDTO);
        return carDTO;
    }
}
