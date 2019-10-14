package com.java.carrental.service.impl;

import com.java.carrental.dto.RentalDTO;
import com.java.carrental.entity.ClientEntity;
import com.java.carrental.entity.RentalEntity;
import com.java.carrental.mappers.RentalMapper;
import com.java.carrental.repository.ClientRepository;
import com.java.carrental.repository.RentalRepository;
import com.java.carrental.service.RentalService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    public RentalDTO addRental(RentalDTO rentalDTO) {

        rentalRepository.save(rentalMapper.rentalDtoToRental(rentalDTO));

        return null;
    }

    @Override
    public List<RentalDTO> findRentalByClientId(Long clientId) {

        Optional<ClientEntity> optionalClientEntity = clientRepository.findById(clientId);
        if (optionalClientEntity.isPresent()) {
            return rentalMapper.listRentalsToRentalDTOs(rentalRepository.findByClient(optionalClientEntity.get()));
        } else {
            return new ArrayList<>();
        }
    }

    @Override
    public RentalDTO findRentalById(Long rentalId) {
        Optional<RentalEntity> optionalRentalEntity = rentalRepository.findById(rentalId);
        return rentalMapper.rentalToRentalDTO(optionalRentalEntity.orElse(new RentalEntity()));
    }

    @Override
    public List<RentalDTO> findRentalByClientLastName(String lastName) {
        List<ClientEntity> clientEntities = clientRepository.findClientByLastName(lastName);
        List<RentalEntity> rentalEntities = new ArrayList<>();

        for (ClientEntity clientEntity : clientEntities) {
            rentalEntities.addAll(rentalRepository.findByClient(clientEntity));
        }
        return rentalMapper.listRentalsToRentalDTOs(rentalEntities);
    }

    @Override
    public List<RentalDTO> findAllByStartDate(String rentalStartDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime rentalStartDateStart = LocalDateTime.parse(rentalStartDate + " 00:00:00", formatter);
        LocalDateTime rentalStartDateEnd = LocalDateTime.parse(rentalStartDate + " 23:59:59", formatter);
        return rentalMapper.listRentalsToRentalDTOs(rentalRepository.findAllByStartDateBetween(rentalStartDateStart, rentalStartDateEnd));
    }
}
