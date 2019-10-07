package com.java.carrental.service.impl;

import com.java.carrental.dto.ClientDTO;
import com.java.carrental.entity.ClientEntity;
import com.java.carrental.mappers.ClientMapper;
import com.java.carrental.repository.ClientRepository;
import com.java.carrental.service.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@AllArgsConstructor(onConstructor = @__(@Autowired))
@Service
public class ClientServiceImpl implements ClientService {

    ClientRepository clientRepository;
    ClientMapper clientMapper;

    @Override
    public List<ClientDTO> findAllClients(){
        List<ClientEntity> clientEntities = clientRepository.findAll();

        List<ClientDTO> clientDTOS = clientMapper.listClientToClientDtos(clientEntities);

        clientDTOS.get(0).getAddress().getCity();

        return clientDTOS;
    }

}
