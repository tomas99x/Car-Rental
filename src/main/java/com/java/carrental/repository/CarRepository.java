package com.java.carrental.repository;

import com.java.carrental.entity.BranchEntity;
import com.java.carrental.entity.CarEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CarRepository extends JpaRepository<CarEntity, Long> {

    @Query("select c from CarEntity c where upper(c.carType) like upper(:carType) and upper(c.carBrandModel) like concat(upper(:carBrandModel), '%')")
    List<CarEntity> findByTypeBrand(String carType, String carBrandModel);

    @Query("select c from CarEntity c where upper(c.carBrandModel) like concat(upper(:brandModel), '%') " +
            "                               and (:carType is null or c.carType like :carType) " +
            "                               and (:branch is null or c.branch like :branch)")
    List<CarEntity> findCarByModelTypeBranch(String brandModel, Enum carType, BranchEntity branch);

}
