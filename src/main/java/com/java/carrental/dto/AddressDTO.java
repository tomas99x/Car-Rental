package com.java.carrental.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AddressDTO {

    @NotBlank
    private String phoneNo;

    @NotBlank
    private String street;

    @NotBlank
    private String houseNo;

    @NotBlank
    private String city;

    @NotBlank
    private String postalCode;
}
