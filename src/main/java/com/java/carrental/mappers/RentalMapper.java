package com.java.carrental.mappers;

import com.java.carrental.dto.EmployeeDTO;
import com.java.carrental.dto.RentalDTO;
import com.java.carrental.entity.EmployeeEntity;
import com.java.carrental.entity.RentalEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RentalMapper {


    RentalDTO rentalToRentalDTO(RentalEntity rentalEntity);

    RentalEntity rentalDtoToRental(RentalDTO rentalDTO);

    List<RentalDTO> listRentalsToRentalDTOs(List<RentalEntity> rentalEntityList);

    List<RentalEntity> listRentalDtoToRentals(List<RentalDTO> rentalDTOs);
}