package com.java.carrental.service;

import com.java.carrental.dto.CarDTO;

import java.util.List;

public interface CarService {

    List<CarDTO> findAllCars();

    CarDTO findCarById(Long id);

    CarDTO saveCar(CarDTO carDTO);

    CarDTO saveCarWithCarKeepersAndBranch(CarDTO carDTO, List<Long> employeeIds, Long branchId);
}
