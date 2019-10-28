package com.java.carrental.dto;

import com.java.carrental.entity.enums.EmployeePosition;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {

    private Long id;

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @NotBlank
    private String workPhoneNo;

    @NotNull
    private EmployeePosition position;

    @NotNull
    private BranchDTO branch;

    private List<CarDTO> cars;
}
