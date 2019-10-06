package com.java.carrental.service;

import com.java.carrental.dto.CarDTO;
import com.java.carrental.dto.CarWithStrKeepersDTO;
import com.java.carrental.entity.BranchEntity;

import java.util.List;

public interface CarService {

    List<CarDTO> findAllCars();

    CarDTO findCarById(Long id);

    CarDTO saveCar(CarDTO carDTO);

    CarDTO saveCarWithCarKeepersAndBranch(CarWithStrKeepersDTO carDTO);

    List<CarDTO> findCarByModelTypeBranch(String brandModel, String type, String branchId);

}
