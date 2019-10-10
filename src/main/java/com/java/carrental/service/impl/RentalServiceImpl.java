package com.java.carrental.service.impl;

import com.java.carrental.dto.RentalDTO;
import com.java.carrental.entity.ClientEntity;
import com.java.carrental.mappers.RentalMapper;
import com.java.carrental.repository.ClientRepository;
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
    ClientRepository clientRepository;

    @Override
    public List<RentalDTO> findAllRentals() {
            return rentalMapper.listRentalsToRentalDTOs(rentalRepository.findAll());
    }

    @Override
    public List<RentalDTO> findRentalByClient(Long clientId){
        ClientEntity clientEntity = clientRepository.findById(clientId).get();
        return rentalMapper.listRentalsToRentalDTOs(rentalRepository.findByClient(clientEntity));
    }
}
