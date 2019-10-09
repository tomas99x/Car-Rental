package com.java.carrental.mappers;

import com.java.carrental.dto.CarDTO;
import com.java.carrental.dto.CarDtoWithLongKeepers;
import com.java.carrental.entity.CarEntity;
import com.java.carrental.entity.EmployeeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.ArrayList;
import java.util.List;

public abstract class CarMapperDecorator implements CarMapper{

    @Autowired
    @Qualifier("delegate")
    private CarMapper delegate;

    @Autowired
    @Qualifier("delegate")
    private EmployeeMapper employeeMapper;


    @Override
    public CarDTO carToCarDTO(CarEntity carEntity) {
        CarDTO carDTO = delegate.carToCarDTO(carEntity);
        carDTO.setCarKeepers(employeeMapper.listEmployeesToEmployeeDTOs(carEntity.getCarKeepers()));
        return carDTO;
    }

    @Override
    public CarDtoWithLongKeepers carToCarDtoWithLongKeepers(CarEntity carEntity){
        CarDtoWithLongKeepers carDtoWithLongKeepers = delegate.carToCarDtoWithLongKeepers(carEntity);

        if ( carEntity.getCarKeepers() !=null && !carEntity.getCarKeepers().isEmpty()  ) {
            carDtoWithLongKeepers.setCarKeepers(new ArrayList<>());
            for (EmployeeEntity employeeEntity : carEntity.getCarKeepers()) {
                carDtoWithLongKeepers.getCarKeepers().add(employeeEntity.getId());
            }
        }

        return carDtoWithLongKeepers;
    }

    @Override
    public CarEntity carDtoToCar(CarDTO carDTO){
        CarEntity carEntity = delegate.carDtoToCar(carDTO);
        carEntity.setCarKeepers(employeeMapper.listEmployeeDtoToEntities(carDTO.getCarKeepers()));
        return carEntity;
    }

    @Override
    public List<CarDTO> listCarToCarDTOs(List<CarEntity> carEntities){
        List<CarDTO> carDTOS = delegate.listCarToCarDTOs(carEntities);

        for (int i=0; i < carDTOS.size(); i++) {
            carDTOS.get(i).setCarKeepers(employeeMapper.listEmployeesToEmployeeDTOs(carEntities.get(i).getCarKeepers()));

        }
        return carDTOS;
    }
}
