package com.java.carrental.dto;

import com.java.carrental.entity.enums.CarColor;
import com.java.carrental.entity.enums.CarType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarDTO {

    private Long id;

    private String carBrandModel;

    private CarType carType;

    private LocalDate productionYear;

    private CarColor carColor;

    private Long engineCapacity;

    private Long horsePower;

    private Long mileage;

    private List<EmployeeDTO> carKeepers;

    //private List<RentalDTO> rentals;

}
