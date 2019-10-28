package com.java.carrental.repository;

import com.java.carrental.entity.CarEntity;
import com.java.carrental.entity.ClientEntity;
import com.java.carrental.entity.RentalEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface RentalRepository extends JpaRepository<RentalEntity, Long> {

    List<RentalEntity> findByClient(ClientEntity clientEntity);

    List<RentalEntity> findAllByStartDateBetween(LocalDateTime rentalStartDateStart, LocalDateTime rentalStartDateEnd);

    List<RentalEntity> findByCar(CarEntity carEntity);

}
