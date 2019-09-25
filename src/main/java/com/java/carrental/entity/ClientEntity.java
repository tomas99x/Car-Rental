package com.java.carrental.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "CLIENT")
public class ClientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    @Column(nullable = false, length = 50)
    private String firstName;

    @Column(nullable = false, length = 50)
    private String lastName;

    @Column(nullable = false, length = 40)
    private String cardNumber;

    @Column(nullable = false)
    private LocalDate birthDate;

    @Embedded
    private Address address;

}
