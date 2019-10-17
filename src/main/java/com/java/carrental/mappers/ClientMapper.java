package com.java.carrental.mappers;

import com.java.carrental.dto.ClientDTO;
import com.java.carrental.entity.ClientEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClientMapper {

    //@Mapping(ignore = true, target = "rentals")
    ClientDTO clientToClientDTO(ClientEntity clientEntity);

    ClientEntity ClientDtoToClient(ClientDTO clientDTO);

    List<ClientDTO> listClientToClientDtos(List<ClientEntity> clientEntities);

    List<ClientEntity> listClientDtoToClients(List<ClientDTO> clientDTOS);
}
