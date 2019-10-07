package com.java.carrental.service.impl;

import com.java.carrental.dto.RentalDTO;
import com.java.carrental.mappers.RentalMapper;
import com.java.carrental.repository.RentalRepository;
import com.java.carrental.service.RentalService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor(onConstructor = @__(@Autowired))
@Service
public class RentalServiceImpl implements RentalService {

    RentalRepository rentalRepository;
    RentalMapper rentalMapper;

    @Override
    public List<RentalDTO> findAllRentals() {
            return rentalMapper.listRentalsToRentalDTOs(rentalRepository.findAll());
    }
}
