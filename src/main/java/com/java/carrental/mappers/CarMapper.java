package com.java.carrental.mappers;

import com.java.carrental.dto.CarDTO;
import com.java.carrental.entity.CarEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CarMapper {

    @Mapping(ignore = true, target = "carKeepers")
    CarDTO carToCarDTO(CarEntity carEntity);

    CarEntity carDtoToCar(CarDTO carDTO);

    List<CarDTO> listCarToCarDTOs(List<CarEntity> carEntityList);

    List<CarEntity> listCarDtoToCars(List<CarDTO> carDTOSet);
}
