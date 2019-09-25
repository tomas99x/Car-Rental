package com.java.carrental.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Address {

    @Column(nullable = false, length = 80)
    private String street;

    @Column(nullable = false, length = 10)
    private String houseNo;

    @Column(nullable = false, length = 60)
    private String city;

    @Column(nullable = false, length = 20)
    private String postalCode;
}
