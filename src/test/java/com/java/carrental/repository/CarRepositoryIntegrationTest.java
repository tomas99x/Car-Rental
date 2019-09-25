package com.java.carrental.repository;

import com.java.carrental.entity.CarEntity;
import com.java.carrental.entity.EmployeeEntity;
import com.java.carrental.entity.enums.CarColor;
import com.java.carrental.entity.enums.CarType;
import com.java.carrental.entity.enums.EmployeePosition;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CarRepositoryIntegrationTest {
    @Autowired
    CarRepository carRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    @Test
    public void shouldFindCarAfterSaveIt() {

        //given
        CarEntity carEntity = new CarEntity(
                "BMW 320",
                CarType.COUPE,
                LocalDate.of(2018, 10, 10),
                CarColor.BLACK,
                200L,
                177L,
                15600L);

        //when
        carRepository.save(carEntity);
        List<CarEntity> carList = carRepository.findAll();

        //then
        assertEquals(1, carList.size());
        assertEquals(carEntity.getCarBrandModel(), carList.get(0).getCarBrandModel());
        assertEquals(carEntity.getCarType(), carList.get(0).getCarType());
        assertEquals(carEntity.getCarColor(), carList.get(0).getCarColor());
        assertEquals(carEntity.getEngineCapacity(), carList.get(0).getEngineCapacity());
        assertEquals(carEntity.getMileage(), carList.get(0).getMileage());

    }

    @Test
    public void shouldDeleteCarAfterSaveIt() {

        //given
        CarEntity carEntity = new CarEntity(
                "BMW 320",
                CarType.COUPE,
                LocalDate.of(2018, 10, 10),
                CarColor.BLACK,
                200L,
                177L,
                15600L);

        //when
        carRepository.save(carEntity);
        List<CarEntity> foundCars = carRepository.findAll();
        carRepository.delete(foundCars.get(0));
        foundCars = carRepository.findAll();

        //then
        assertEquals(0, foundCars.size());
    }

    @Test
    public void shouldUpdateCarAfterSaveIt() {

        //given
        CarEntity carEntity = new CarEntity(
                "BMW 320",
                CarType.COUPE,
                LocalDate.of(2018, 10, 10),
                CarColor.BLACK,
                200L,
                177L,
                15600L);

        //when
        carRepository.save(carEntity);
        List<CarEntity> carList = carRepository.findAll();
        carList.get(0).setCarBrandModel("Audi A3");
        carRepository.save(carList.get(0));
        carList = carRepository.findAll();

        //then
        assertEquals(1, carList.size());
        assertEquals("Audi A3", carList.get(0).getCarBrandModel());
        assertEquals(carEntity.getCarType(), carList.get(0).getCarType());
        assertEquals(carEntity.getCarColor(), carList.get(0).getCarColor());
        assertEquals(carEntity.getEngineCapacity(), carList.get(0).getEngineCapacity());
        assertEquals(carEntity.getMileage(), carList.get(0).getMileage());
    }

    @Test
    public void shouldFindCarByCarBrandModelAndType() {

        //given
        carRepository.save(new CarEntity(
                "BMW 320",
                CarType.COUPE,
                LocalDate.of(2018, 10, 10),
                CarColor.BLACK,
                200L,
                177L,
                15600L)
        );

        carRepository.save(new CarEntity(
                "BMW 320",
                CarType.COMBI,
                LocalDate.of(2018, 10, 10),
                CarColor.BLACK,
                200L,
                177L,
                15600L)
        );

        carRepository.save(new CarEntity(
                "Audi A4",
                CarType.COUPE,
                LocalDate.of(2018, 10, 10),
                CarColor.BLACK,
                200L,
                177L,
                15600L)
        );

        //when
        List<CarEntity> carList = carRepository.findByTypeBrand("COUPE", "BMW 320");

        //then
        assertEquals(1, carList.size());
        assertEquals("BMW 320", carList.get(0).getCarBrandModel());
        assertEquals(CarType.COUPE, carList.get(0).getCarType());

    }

    @Test
    public void shouldFindCarWithEmployeeAfterSaveIt() {

        //given
        Set<EmployeeEntity> employeeEntity = new HashSet<>();

        employeeEntity.add(new EmployeeEntity(
                "Andrzej",
                "Nowak",
                EmployeePosition.SELLER)
        );

        CarEntity carEntity = new CarEntity(
                "BMW 320",
                CarType.COUPE,
                LocalDate.of(2018, 10, 10),
                CarColor.BLACK,
                200L,
                177L,
                15600L
        );

        carEntity.setCarKeepers(employeeEntity);

        //when
        carRepository.save(carEntity);
        List<CarEntity> carList = carRepository.findAll();

        //then
        assertEquals(1, carList.size());
        assertEquals(carEntity.getCarBrandModel(), carList.get(0).getCarBrandModel());
        assertEquals(carEntity.getCarType(), carList.get(0).getCarType());
        assertEquals(carEntity.getCarColor(), carList.get(0).getCarColor());
        assertEquals(carEntity.getEngineCapacity(), carList.get(0).getEngineCapacity());
        assertEquals(carEntity.getMileage(), carList.get(0).getMileage());

        assertEquals(employeeEntity.iterator().next().getFirstName(), carList.get(0).getCarKeepers().iterator().next().getFirstName());
        assertEquals("Nowak", carList.get(0).getCarKeepers().iterator().next().getLastName());
    }
}
