package com.java.carrental.service.impl;

import com.java.carrental.dto.ClientDTO;
import com.java.carrental.dto.RentalDTO;
import com.java.carrental.mappers.ClientMapper;
import com.java.carrental.repository.ClientRepository;
import com.java.carrental.service.ClientService;
import com.java.carrental.service.RentalService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@AllArgsConstructor(onConstructor = @__(@Autowired))
@Service
public class ClientServiceImpl implements ClientService {

    ClientRepository clientRepository;
    ClientMapper clientMapper;
    RentalService rentalService;

    @Override
    public List<ClientDTO> findAllClients(){
        return clientMapper.listClientToClientDtos(clientRepository.findAll());
    }

    @Override
    public ClientDTO findClientById(Long clientId){
        return clientMapper.clientToClientDTO(clientRepository.findById(clientId).get());
    }

    @Override
    public List<RentalDTO>  findClientRentals(Long clientId){
        return rentalService.findRentalByClient(clientId);
    }



}
