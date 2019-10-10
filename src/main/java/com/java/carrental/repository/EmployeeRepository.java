package com.java.carrental.repository;

import com.java.carrental.entity.BranchEntity;
import com.java.carrental.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {


    List<EmployeeEntity> findByBranch(BranchEntity branchEntity);

    @Query("SELECT f FROM EmployeeEntity f WHERE LOWER(f.firstName) = LOWER(:name)")
    EmployeeEntity retrieveByName(@Param("name") String name);

    @Query(
            value = "SELECT * FROM employee e where e.first_Name = :firstName AND e.last_Name = :lastName AND e.position =:position ",
            nativeQuery=true
    )
    public Optional<EmployeeEntity> findByFirstNameLastNamePosition(@Param("firstName") String firstName,
                                                                    @Param("lastName") String description,
                                                                    @Param("position") String position);
}
