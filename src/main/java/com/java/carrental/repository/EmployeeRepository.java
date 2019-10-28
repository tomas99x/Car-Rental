package com.java.carrental.repository;

import com.java.carrental.entity.BranchEntity;
import com.java.carrental.entity.EmployeeEntity;
import com.java.carrental.entity.enums.EmployeePosition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {


    List<EmployeeEntity> findEmployeesByBranch(BranchEntity branchEntity);

    @Query("SELECT e FROM EmployeeEntity e WHERE LOWER(e.firstName) = LOWER(:name)")
    EmployeeEntity retrieveByName(@Param("name") String name);

    @Query("SELECT e FROM EmployeeEntity e where e.firstName = :firstName AND e.lastName = :lastName AND e.position =:position " )
    List<EmployeeEntity> findEmployeesByFirstNameLastNamePosition(@Param("firstName") String firstName,
                                                                    @Param("lastName") String description,
                                                                    @Param("position") EmployeePosition position);
}
