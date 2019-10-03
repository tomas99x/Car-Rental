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
    //@Mapping(source = "branch", target = "branch.address.city")

    CarEntity carDtoToCar(CarDTO carDTO);




//    @Mapping(ignore = true, target = "carKeepers")
//    CarDTO carToCarDtoWithRentals(CarEntity carEntity);
//
//
//    CarEntity carDtoToCarWithRentals(CarDTO carDTO);


}
