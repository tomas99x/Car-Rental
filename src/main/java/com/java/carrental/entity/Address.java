package com.java.carrental.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Address {

    @Column(nullable = false, length = 20)
    private String phoneNo;

    @Column(nullable = false, length = 80)
    private String street;

    @Column(nullable = false, length = 10)
    private String houseNo;

    @Column(nullable = false, length = 60)
    private String city;

    @Column(nullable = false, length = 20)
    private String postalCode;
}
