package com.java.carrental.mappers;

import com.java.carrental.dto.CarDTO;
import com.java.carrental.dto.CarWithStrKeepersDTO;
import com.java.carrental.entity.CarEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CarWithRentalsMapper {

    @Mapping(ignore = true, target = "carKeepers")
    @Mapping(ignore = true, target = "rentals")
    @Mapping(ignore = true, target = "branch")
    CarEntity carDtoToCar(CarWithStrKeepersDTO carWithStrKeepersDTO);

    @Mapping(source = "branch.id", target = "branch")
    @Mapping(ignore = true, target = "carKeepers")
    CarWithStrKeepersDTO carDtoToCarWithStrKeepersDto( CarDTO carDTO);

}
