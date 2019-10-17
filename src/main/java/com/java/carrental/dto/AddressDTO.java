package com.java.carrental.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AddressDTO {

    @NotNull
    private String phoneNo;

    private String street;

    private String houseNo;

    @NotNull
    private String city;

    @NotNull
    private String postalCode;
}
