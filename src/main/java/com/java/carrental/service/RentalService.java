package com.java.carrental.service;

import com.java.carrental.dto.RentalDTO;

import java.util.List;

public interface RentalService {

    List<RentalDTO> findAllRentals();

    List<RentalDTO> findRentalByClient(Long clientId);
}
