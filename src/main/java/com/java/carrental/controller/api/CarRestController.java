package com.java.carrental.controller.api;


import com.java.carrental.dto.CarDTO;
import com.java.carrental.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CarRestController {

    private CarService carService;

    @Autowired
    public CarRestController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/api/cars")
    public ResponseEntity<List<CarDTO>> findAllCars() {
        List<CarDTO> allCars = carService.findAllCars();
        return ResponseEntity.ok().body(allCars);
    }

    @GetMapping("/api/car/{id}")
    public ResponseEntity<CarDTO> findCar(@PathVariable("id") Long id) {
        if (id < 0) {
            return ResponseEntity.badRequest().body(null);
        }
        CarDTO car = carService.findCarById(id);
        return ResponseEntity.ok().body(car);
    }

}
