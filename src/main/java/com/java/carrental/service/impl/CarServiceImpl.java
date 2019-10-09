package com.java.carrental.service.impl;

import com.java.carrental.controller.CarController;
import com.java.carrental.dto.CarDTO;
import com.java.carrental.dto.CarDtoWithLongKeepers;
import com.java.carrental.entity.BranchEntity;
import com.java.carrental.entity.CarEntity;
import com.java.carrental.entity.EmployeeEntity;
import com.java.carrental.entity.enums.CarType;
import com.java.carrental.mappers.CarMapper;
import com.java.carrental.repository.BranchRepository;
import com.java.carrental.repository.CarRepository;
import com.java.carrental.repository.EmployeeRepository;
import com.java.carrental.service.CarService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor(onConstructor = @__(@Autowired))
@Service
public class CarServiceImpl implements CarService {

    private CarMapper carMapper;
    private CarRepository carRepository;
    private EmployeeRepository employeeRepository;
    private BranchRepository branchRepository;


    @Override
    public List<CarDTO> findAllCars() {
        List<CarEntity> carEntities = carRepository.findAll();
        return carMapper.listCarToCarDTOs(carEntities);
    }

    @Override
    public CarDTO findCarById(Long id) {
        CarEntity carEntity = carRepository.findById(id).get();
        return carMapper.carToCarDTO(carEntity);
    }

    @Override
    public CarDtoWithLongKeepers findCarByIdWithLongKeepers(Long id) {
        CarEntity carEntity = carRepository.findById(id).get();
        return carMapper.carToCarDtoWithLongKeepers(carEntity);
    }


    @Override
    public CarDTO saveCar(CarDTO carDTO) {
        CarEntity carEntity = carRepository.save(carMapper.carDtoToCar(carDTO));
        return carMapper.carToCarDTO(carEntity);
    }

    @Override
    public CarDTO saveCarWithCarKeepersAndBranch(CarDtoWithLongKeepers carDTO) {

        CarEntity carEntity = carMapper.carDtoWithLongKeepersTOCar(carDTO);

        List<EmployeeEntity> employeeEntities = new ArrayList<>();
        if (carDTO.getCarKeepers() != null) {
            for (Long keeper : carDTO.getCarKeepers()) {
                employeeEntities.add(employeeRepository.findById(keeper).get());
            }
        }

        BranchEntity branchEntity = null;
        if (carDTO.getBranch() != null) {
            branchEntity = branchRepository.findById(carDTO.getBranch()).get();
        }

        carEntity.setBranch(branchEntity);
        carEntity.setCarKeepers(employeeEntities);
        carEntity = carRepository.save(carEntity);
        return carMapper.carToCarDTO(carEntity);
    }

    @Override
    public List<CarDTO> findCarByModelTypeBranch(String brandModel,  String type, String branchId) {

        Enum<CarType> carTypeEnum = null;
        if (!CarController.defaultValue.equals(type)){
            carTypeEnum = CarType.valueOf(type);
        }

        Long id;
        BranchEntity branchEntity = null;
        if (!"none".equals(branchId)) {
            id = Long.parseLong(branchId);
            branchEntity = branchRepository.findById(id).get();
        }

        List<CarEntity> carEntity = carRepository.findCarByModelTypeBranch(brandModel, carTypeEnum, branchEntity);
        return carMapper.listCarToCarDTOs(carEntity);
    }

}
