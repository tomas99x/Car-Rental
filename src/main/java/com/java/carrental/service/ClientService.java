package com.java.carrental.service;

import com.java.carrental.dto.ClientDTO;
import com.java.carrental.dto.RentalDTO;

import java.util.List;

public interface ClientService {
    List<ClientDTO> findAllClients();

    ClientDTO findClientById(Long clientId);

    List<RentalDTO> findClientRentals(Long clientId);

    ClientDTO addClient(ClientDTO clientDTO);
}
