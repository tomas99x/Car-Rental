package com.java.carrental.mappers;

import com.java.carrental.dto.CarDTO;
import com.java.carrental.entity.CarEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CarWithRentalsMapper {

    @Mapping(ignore = true, target = "carKeepers")

    //@Mapping(source = "branch.address.city", target = "branch")
    CarDTO carToCarDTO(CarEntity carEntity);

    //@Mapping(ignore = true, target = "carKeepers")
    //@Mapping(ignore = true, target = "branch")
    //@Mapping(ignore = true, target = "id")
    CarEntity carDtoToCar(CarDTO carDTO);

}
