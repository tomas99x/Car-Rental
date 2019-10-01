package com.java.carrental.controller;

import com.java.carrental.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CarController {

    @Autowired
    CarService carService;

    @GetMapping("/cars")
    public String listCars(Model model){
        model.addAttribute("cars", carService.findAllCars());
        return "list-cars";
    }
}
