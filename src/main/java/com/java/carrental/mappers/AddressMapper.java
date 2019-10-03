package com.java.carrental.mappers;

import com.java.carrental.dto.AddressDTO;
import com.java.carrental.entity.Address;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressMapper {

    AddressDTO addressToAddressDTO(Address address);

    Address addressDtoToAddress(AddressDTO addressDTO);

}
