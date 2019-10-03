package com.java.carrental.mappers;

import com.java.carrental.dto.CarDTO;
import com.java.carrental.entity.CarEntity;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CarMapper {

    @Mapping(ignore = true, target = "carKeepers")
    @Mapping(ignore = true, target = "rentals")
    //@Mapping(source = "branch.address.city", target = "branch")
    CarDTO carToCarDTO(CarEntity carEntity);

    //@Mapping(ignore = true, target = "carKeepers")
    //@Mapping(ignore = true, target = "branch")
    //@Mapping(ignore = true, target = "id")
    //@Mapping(source = "branch", target = "branch.address.city")
    @Mapping(ignore = true, target = "rentals")
    CarEntity carDtoToCar(CarDTO carDTO);

    List<CarDTO> listCarToCarDTOs(List<CarEntity> carEntityList);

    List<CarEntity> listCarDtoToCars(List<CarDTO> carDTOSet);


//    @Mapping(ignore = true, target = "carKeepers")
//    CarDTO carToCarDtoWithRentals(CarEntity carEntity);
//
//
//    CarEntity carDtoToCarWithRentals(CarDTO carDTO);


}
