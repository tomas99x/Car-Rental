package com.java.carrental.mappers;

import com.java.carrental.dto.RentalDTO;
import com.java.carrental.entity.RentalEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring")
public abstract class  RentalMapper {

    @Autowired
    @Qualifier("delegate")
    CarMapper carMapper;

    @Mapping(ignore = true, target = "car")
    public abstract RentalDTO rentalToRentalDtoWithoutCar(RentalEntity rentalEntity);

   public RentalDTO rentalToRentalDTO(RentalEntity rentalEntity) {

        RentalDTO rentalDTO = rentalToRentalDtoWithoutCar(rentalEntity);
        //CarMapper carMapper = new CarMapperImpl_();
        rentalDTO.setCar(carMapper.carToCarDTO(rentalEntity.getCar()));

        return rentalDTO;
    }

    public abstract RentalEntity rentalDtoToRental(RentalDTO rentalDTO);

    public List<RentalDTO> listRentalsToRentalDTOs(List<RentalEntity> rentalEntityList){

        if ( rentalEntityList == null ) {
            return null;
        }

        List<RentalDTO> list = new ArrayList<>( rentalEntityList.size() );
        for ( RentalEntity rentalEntity : rentalEntityList ) {
            list.add(rentalToRentalDTO( rentalEntity ) );
        }

        return list;
    }

    public abstract List<RentalEntity> listRentalDtoToRentals(List<RentalDTO> rentalDTOs);
}
