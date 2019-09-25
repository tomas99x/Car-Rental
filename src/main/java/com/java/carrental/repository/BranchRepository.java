package com.java.carrental.repository;

import com.java.carrental.entity.BranchEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BranchRepository extends JpaRepository<BranchEntity, Long> {
}
