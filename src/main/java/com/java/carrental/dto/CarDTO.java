package com.java.carrental.dto;

import com.java.carrental.entity.enums.CarColor;
import com.java.carrental.entity.enums.CarType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CarDTO {

    private Long id;

    private String carBrandModel;

    private CarType carType;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate productionYear;

    private CarColor carColor;

    private Long engineCapacity;

    private Long horsePower;

    private Long mileage;

    private List<EmployeeDTO> carKeepers;

    private BranchDTO branch;

    private List<RentalDTO> rentals;

}
