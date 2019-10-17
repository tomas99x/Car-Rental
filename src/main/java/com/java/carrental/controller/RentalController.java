package com.java.carrental.controller;

import com.java.carrental.constants.ModelConstants;
import com.java.carrental.constants.ViewNames;
import com.java.carrental.dto.RentalDTO;
import com.java.carrental.service.BranchService;
import com.java.carrental.service.CarService;
import com.java.carrental.service.ClientService;
import com.java.carrental.service.RentalService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor(onConstructor = @__(@Autowired))
@Controller
public class RentalController {

    RentalService rentalService;
    ClientService clientService;
    BranchService branchService;
    CarService carService;

    @GetMapping("/rentalList")
    public String findAllRentals(Model model) {
        model.addAttribute("rentals", rentalService.findAllRentals());
        model.addAttribute("localDateTime", LocalDate.now());
        return ViewNames.RENTAL_LIST;
    }


    @GetMapping("/addRental")
    public String rentalForm (Model model){
        model.addAttribute("rental", new RentalDTO());
        model.addAttribute("branchesAllValues", branchService.findAllBranches());
        //model.addAttribute("allCars", carService.findAllCars());
        model.addAttribute("allClients", clientService.findAllClients());
        model.addAttribute("hiddeCarSection", true);

        return ViewNames.RENTAL_ADD_FORM;
    }

    @PostMapping("/addRental")
    public String addRentalForm (@ModelAttribute("rental") @Valid RentalDTO rentalDTO,
                                 BindingResult bindingResult, Model model,
                                 @RequestParam(name = "rentalAction", required = false) String rentalAction){
        if (bindingResult.hasErrors()) {
            model.addAttribute("branchesAllValues", branchService.findAllBranches());
            //model.addAttribute("allCars", carService.findAllCars());
            model.addAttribute("allClients", clientService.findAllClients());
            model.addAttribute("hiddeCarSection", true);
            return ViewNames.RENTAL_ADD_FORM;
        }

        if ("actionSearchCar".equals(rentalAction)){
            model.addAttribute("allCars", carService.findCarsForRental(rentalDTO));
            model.addAttribute("branchesAllValues", branchService.findAllBranches());
            model.addAttribute("allClients", clientService.findAllClients());
            model.addAttribute("hiddeCarSection", false);
            return ViewNames.RENTAL_ADD_FORM;
        }

        if ("actionAddRental".equals(rentalAction)){
            rentalService.addRental(rentalDTO);
        }

        return "redirect:/rentalList";
    }


    //TODO implement editRentalForm method
    @GetMapping("/editRental")
    public String editRentalForm(@RequestParam(name = "rentalId") Long rentalId, Model model){
        model.addAttribute("rental", rentalService.findRentalById(rentalId));
        model.addAttribute("branchesAllValues", branchService.findAllBranches());
        model.addAttribute("allClients", clientService.findAllClients());
        model.addAttribute("allCars", carService.findAllCars());
        return ViewNames.RENTAL_UPDATE_FORM;
    }

    @GetMapping("/searchRental")
    public String searchRental(Model model, @RequestParam(required = false) Long rentalNumber,
                               @RequestParam(defaultValue = ModelConstants.NO_VALUE) String clientLastName,
                               @RequestParam(defaultValue = ModelConstants.NO_VALUE) String rentalStartDate) {

        List<RentalDTO> rentalDTOS = new ArrayList<>();

        if (rentalNumber != null) {
            if (rentalNumber > 0) {
                rentalDTOS.add(rentalService.findRentalById(rentalNumber));
            }
        } else if (!ModelConstants.NO_VALUE.equals(clientLastName)) {
            rentalDTOS = rentalService.findRentalByClientLastName(clientLastName);
        } else if (!ModelConstants.NO_VALUE.equals(rentalStartDate)) {
            rentalDTOS = rentalService.findAllByStartDate(rentalStartDate);
        } else {
            rentalDTOS = rentalService.findAllRentals();
        }

        model.addAttribute("rentals", rentalDTOS);
        return ViewNames.RENTAL_LIST;
    }
}
