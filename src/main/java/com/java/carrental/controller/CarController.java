package com.java.carrental.controller;

import com.java.carrental.dto.BranchDTO;
import com.java.carrental.dto.CarDTO;
import com.java.carrental.dto.CarWithStrKeepersDTO;
import com.java.carrental.dto.EmployeeDTO;
import com.java.carrental.mappers.CarWithRentalsMapper;
import com.java.carrental.mappers.EmployeeMapper;
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
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor(onConstructor = @__(@Autowired))
@Controller
public class CarController {

    CarService carService;
    EmployeeService employeeService;
    EmployeeMapper employeeMapper;
    BranchService branchService;
    CarWithRentalsMapper carWithRentalsMapper;

    @GetMapping("/cars")
    public String listCars(Model model){
        model.addAttribute("cars", carService.findAllCars());
        return "list-cars";
    }

    @GetMapping("/addCar")
    public String carForm(Model model){
        model.addAttribute("car", new CarDTO());
        return "car-form";
    }

    @ModelAttribute("keepersAllValues")
    public List<EmployeeDTO> getKeepersAllValues (){
        return employeeService.findAllEmployees();
    }

    @ModelAttribute("branchesAllValues")
    public List<BranchDTO> getBranchesAllValues (){
        return branchService.findAllBranches();
    }

    @PostMapping("/addCar")
    public String addCar(@ModelAttribute("car") @Valid CarWithStrKeepersDTO carDTO, BindingResult bindingResult){

        if (bindingResult.hasErrors()) {
            System.out.println("BINDING RESULT ERROR");
            return "car-form";
        }
        carService.saveCarWithCarKeepersAndBranch(carDTO);
        return "redirect:/cars";
    }

    @GetMapping("/editCar")
    public String editCarForm(Model model,  @RequestParam(name = "carId") Long carId){

        CarDTO carDTO = carService.findCarById(carId);
        CarWithStrKeepersDTO carWithStrKeepersDTO = carWithRentalsMapper.carDtoToCarWithStrKeepersDto(carDTO);

            if ( carDTO.getCarKeepers() !=null && !carDTO.getCarKeepers().isEmpty()  ) {
                carWithStrKeepersDTO.setCarKeepers(new ArrayList<>());
                for (EmployeeDTO employeeDTO : carDTO.getCarKeepers()) {
                    carWithStrKeepersDTO.getCarKeepers().add(employeeDTO.getId());
                }
            }

        model.addAttribute("car", carWithStrKeepersDTO);
        return "car-update-form";
    }

}
