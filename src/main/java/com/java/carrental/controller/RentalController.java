package com.java.carrental.controller;

import com.java.carrental.service.RentalService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@AllArgsConstructor(onConstructor = @__(@Autowired))
@Controller
public class RentalController {

    RentalService rentalService;


    @GetMapping("/rentals")
    public String findAllRentals(Model model){
        model.addAttribute("rentals", rentalService.findAllRentals());
        return "rental-list";
    }
}
