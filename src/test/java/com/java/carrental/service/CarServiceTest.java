package com.java.carrental.service;

import com.java.carrental.dto.CarDTO;
import com.java.carrental.entity.enums.CarColor;
import com.java.carrental.entity.enums.CarType;
import com.java.carrental.mappers.CarMapper;
import com.java.carrental.mappers.EmployeeMapper;
import com.java.carrental.repository.CarRepository;
import com.java.carrental.service.impl.CarServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(MockitoJUnitRunner.class)
public class CarServiceTest {


    @Mock
    CarRepository carRepository;

    @Mock
    CarMapper carMapper;

    @Mock
    EmployeeMapper employeeMapper;

    @InjectMocks
    CarServiceImpl carService;


    @Test
    public void findAllCars() {

        //given
        CarDTO carDTO = new CarDTO(
               1L,
                "BMW 320",
                CarType.COUPE,
                LocalDate.of(2018, 10, 10),
                CarColor.BLACK,
                2000L,
                177L,
                15600L,
                null,
                null,
                null);

        //when
        List<CarDTO> carList = new ArrayList<>();
        carList.add(carDTO);
        Mockito.when(carService.findCarById(1L)).thenReturn(carList.get(0));


        //then
        assertThat("BMW 320").isEqualTo(carService.findCarById(1L).getCarBrandModel());
        assertThat(CarType.COUPE).isEqualTo(carService.findCarById(1L).getCarType());
        assertThat(CarColor.BLACK).isEqualTo(carService.findCarById(1L).getCarColor());
        Mockito.verify(carService,Mockito.atLeast(2)).findCarById(1L);
    }

    @Test
    public void findCarById() {
    }
}