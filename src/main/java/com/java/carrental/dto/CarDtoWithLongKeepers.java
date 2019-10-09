package com.java.carrental.dto;

import com.java.carrental.entity.enums.CarColor;
import com.java.carrental.entity.enums.CarType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CarDtoWithLongKeepers {

    private Long id;

    @NotBlank
    private String carBrandModel;

    @NotNull
    private CarType carType;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate productionYear;

    @NotNull
    private CarColor carColor;

    @NotNull
    private Long engineCapacity;

    @NotNull
    private Long horsePower;

    @NotNull
    private Long mileage;

    private List<Long> carKeepers;

    private Long branch;

    private List<RentalDTO> rentals;

}
