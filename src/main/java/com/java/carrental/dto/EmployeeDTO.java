package com.java.carrental.dto;

import com.java.carrental.entity.enums.EmployeePosition;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {

    private Long id;

    private String firstName;

    private String lastName;

    private EmployeePosition position;

    private BranchDTO branch;

    private List<CarDTO> cars;
}
