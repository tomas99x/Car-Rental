package com.java.carrental.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.Valid;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BranchDTO {

    private Long id;

    @Valid
    private AddressDTO address;
}
