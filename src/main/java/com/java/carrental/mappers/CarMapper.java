package com.java.carrental.mappers;

import com.java.carrental.dto.CarDTO;
import com.java.carrental.dto.CarDtoWithLongKeepers;
import com.java.carrental.entity.CarEntity;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
@DecoratedWith(CarMapperDecorator.class)
public interface CarMapper {

    @Mapping(ignore = true, target = "carKeepers")
    @Mapping(ignore = true, target = "rentals")
    CarDTO carToCarDTO(CarEntity carEntity);

    @Mapping(source = "branch.id", target = "branch")
    @Mapping(ignore = true, target = "carKeepers")
    CarDtoWithLongKeepers carToCarDtoWithLongKeepers(CarEntity carEntity);

    @Mapping(ignore = true, target = "carKeepers")
    CarEntity carDtoToCar(CarDTO carDTO);

    @Mapping(ignore = true, target = "carKeepers")
    @Mapping(ignore = true, target = "branch")
    CarEntity carDtoWithLongKeepersTOCar(CarDtoWithLongKeepers carDtoWithLongKeepers);

    List<CarDTO> listCarToCarDTOs(List<CarEntity> carEntities);

    List<CarEntity> listCarDtoToCars(List<CarDTO> carDTOS);

}
