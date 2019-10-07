package com.java.carrental.service;

import com.java.carrental.dto.ClientDTO;

import java.util.List;

public interface ClientService {
    List<ClientDTO> findAllClients();
}
