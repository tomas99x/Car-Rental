package com.java.carrental.service;

import com.java.carrental.dto.CarDTO;
import com.java.carrental.dto.CarDtoWithLongKeepers;

import java.util.List;

public interface CarService {

    List<CarDTO> findAllCars();

    CarDTO findCarById(Long id);

    CarDtoWithLongKeepers findCarByIdWithLongKeepers(Long id);

    CarDTO saveCar(CarDTO carDTO);

    CarDTO saveCarWithCarKeepersAndBranch(CarDtoWithLongKeepers carDTO);

    List<CarDTO> findCarByModelTypeBranch(String brandModel, String type, String branchId);

}
