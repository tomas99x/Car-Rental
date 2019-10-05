package com.java.carrental.service.impl;

import com.java.carrental.dto.CarDTO;
import com.java.carrental.dto.CarWithStrKeepersDTO;
import com.java.carrental.dto.EmployeeDTO;
import com.java.carrental.entity.BranchEntity;
import com.java.carrental.entity.CarEntity;
import com.java.carrental.entity.EmployeeEntity;
import com.java.carrental.mappers.CarMapper;
import com.java.carrental.mappers.CarWithRentalsMapper;
import com.java.carrental.mappers.EmployeeMapper;
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
    private CarWithRentalsMapper carWithRentalsMapper;
    private EmployeeMapper employeeMapper;
    private CarRepository carRepository;
    private EmployeeRepository employeeRepository;
    private BranchRepository branchRepository;

    @Override
    public List<CarDTO> findAllCars() {
        List<CarEntity> carEntities = carRepository.findAll();
        return listCarToCarDTOs(carEntities);
    }

    @Override
    public CarDTO findCarById(Long id) {
        CarEntity carEntity = carRepository.findById(id).get();
        return carToCarDTO(carEntity);
    }


    private List<CarDTO> listCarToCarDTOs(List<CarEntity> carEntityList) {
        if (carEntityList == null) {
            return null;
        }

        List<CarDTO> list = new ArrayList<>(carEntityList.size());
        for (CarEntity carEntity : carEntityList) {
            list.add(carToCarDTO(carEntity));
        }

        return list;
    }

    private CarDTO carToCarDTO(CarEntity carEntity) {
        List<EmployeeDTO> employeeDTO = employeeMapper.listEmployeesToEmployeeDTOs(carEntity.getCarKeepers());
        CarDTO carDTO = carMapper.carToCarDTO(carEntity);
        carDTO.setCarKeepers(employeeDTO);
        return carDTO;
    }


    @Override
    public CarDTO saveCar(CarDTO carDTO) {
        CarEntity carEntity = carRepository.save(carMapper.carDtoToCar(carDTO));
        return carMapper.carToCarDTO(carEntity);
    }

    @Override
    public CarDTO saveCarWithCarKeepersAndBranch(CarWithStrKeepersDTO carDTO) {

        CarEntity carEntity = carWithRentalsMapper.carDtoToCar(carDTO);

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
}
