package com.java.carrental.repository;

import com.java.carrental.entity.ClientEntity;
import com.java.carrental.entity.RentalEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RentalRepository extends JpaRepository<RentalEntity, Long>{

    List<RentalEntity> findByClient(ClientEntity clientEntity);
}