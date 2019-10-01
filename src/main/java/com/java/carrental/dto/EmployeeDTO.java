package com.java.carrental.dto;

import com.java.carrental.entity.enums.EmployeePosition;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {

    private Long id;

    private String firstName;

    private String lastName;

    private EmployeePosition position;

    private String branch;

    private List<CarDTO> cars;
}
