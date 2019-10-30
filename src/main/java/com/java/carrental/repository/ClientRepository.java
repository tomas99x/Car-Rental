package com.java.carrental.repository;

import com.java.carrental.entity.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<ClientEntity, Long> {

    //@Query("select c from ClientEntity c where upper(c.lastName) like concat(upper(:lastName), '%') ")
    List<ClientEntity> findByLastNameContaining(String lastName);

    @Query("select c from ClientEntity c where upper(c.firstName) like concat(upper(:firstName), '%') " +
            "                              and upper(c.lastName) like concat(upper(:lastName), '%' ) " +
            "                              and upper(c.address.city) like concat( '%', upper(:city), '%')")
    List<ClientEntity> findByFirstNameOrLastNameOrAddress(String firstName, String lastName, String city);
}
