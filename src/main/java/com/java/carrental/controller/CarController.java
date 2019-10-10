package com.java.carrental.controller;

import com.java.carrental.dto.CarDTO;
import com.java.carrental.dto.CarDtoWithLongKeepers;
import com.java.carrental.mappers.CarMapper;
import com.java.carrental.service.BranchService;
import com.java.carrental.service.CarService;
import com.java.carrental.service.EmployeeService;
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

@AllArgsConstructor(onConstructor = @__(@Autowired))
@Controller
public class CarController {

    CarService carService;
    CarMapper carMapper;
    EmployeeService employeeService;
    BranchService branchService;

    public static final String NOVALUE = "none";

    @GetMapping("/carList")
    public String listCars(Model model){
        model.addAttribute("cars", carService.findAllCars());
        model.addAttribute("branchesAllValues", branchService.findAllBranches());
        return "/car-list";
    }

    @GetMapping("/addCar")
    public String carForm(Model model){
        model.addAttribute("car", new CarDTO());
        model.addAttribute("keepersAllValues", employeeService.findAllEmployees());
        model.addAttribute("branchesAllValues", branchService.findAllBranches());
        return "car-add-form";
    }

    @PostMapping("/addCar")
    public String addCar(@ModelAttribute("car") @Valid CarDtoWithLongKeepers carDTO, BindingResult bindingResult, Model model){

        if (bindingResult.hasErrors()) {
            System.out.println("BINDING RESULT ERROR");
            model.addAttribute("keepersAllValues", employeeService.findAllEmployees());
            model.addAttribute("branchesAllValues", branchService.findAllBranches());
            return "car-add-form";
        }
        carService.saveCarWithCarKeepersAndBranch(carDTO);
        return "redirect:/cars";
    }

    @GetMapping("/editCar")
    public String editCarForm(Model model, @RequestParam(name = "carId") Long carId){
        model.addAttribute("car", carService.findCarByIdWithLongKeepers(carId));
        model.addAttribute("keepersAllValues", employeeService.findAllEmployees());
        model.addAttribute("branchesAllValues", branchService.findAllBranches());
        return "car-update-form";
    }

    @GetMapping("/search")
    public String searchCarTypeBranch(Model model, @RequestParam(defaultValue = "")String carBrandModel,
                                      @RequestParam(defaultValue = "null") String carType,
                                      @RequestParam(defaultValue = "none") String branch){

        model.addAttribute("cars", carService.findCarByModelTypeBranch(carBrandModel, carType, branch));
        model.addAttribute("branchesAllValues", branchService.findAllBranches());
        return "car-list";
    }

}
