package com.java.carrental.service;

import com.java.carrental.dto.RentalDTO;

import java.util.List;

public interface RentalService {

    List<RentalDTO> findAllRentals();

    RentalDTO addRental (RentalDTO rentalDTO);

    List<RentalDTO> findRentalByClientId(Long clientId);

    RentalDTO findRentalById(Long rentalId);

    List<RentalDTO> findRentalByClientLastName(String lastName);

    List<RentalDTO> findAllByStartDate(String rentalStartDate);


}
