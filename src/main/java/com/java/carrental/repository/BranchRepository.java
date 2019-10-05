package com.java.carrental.repository;

import com.java.carrental.entity.BranchEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface BranchRepository extends JpaRepository<BranchEntity, Long> {


    Optional<BranchEntity> findByAddressCity(String city);
}
