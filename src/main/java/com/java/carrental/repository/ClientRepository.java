package com.java.carrental.repository;

import com.java.carrental.entity.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<ClientEntity, Long> {

    @Query("select c from ClientEntity c where upper(c.lastName) like concat(upper(:lastName), '%') ")
    List<ClientEntity> findByLastName(String lastName);
}
