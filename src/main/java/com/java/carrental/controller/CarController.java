package com.java.carrental.controller;

import com.java.carrental.dto.CarDTO;
import com.java.carrental.dto.EmployeeDTO;
import com.java.carrental.mappers.EmployeeMapper;
import com.java.carrental.service.BranchService;
import com.java.carrental.service.CarService;
import com.java.carrental.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.List;

@AllArgsConstructor(onConstructor = @__(@Autowired))
@Controller
public class CarController {

    CarService carService;
    EmployeeService employeeService;
    EmployeeMapper employeeMapper;
    BranchService branchService;

    @GetMapping("/cars")
    public String listCars(Model model){
        model.addAttribute("cars", carService.findAllCars());
        return "list-cars";
    }

    @GetMapping("/addCar")
    public String carForm(Model model){
        CarDTO carDTO = new CarDTO();
        model.addAttribute("car", carDTO);
        model.addAttribute("employees", employeeService.findAllEmployees());
        model.addAttribute("branches", branchService.findAllBranches());
        return "car-form";
    }

    @PostMapping("/addCar")
    public String addCar(@ModelAttribute("car") CarDTO carDTO, 
                         @RequestParam(name = "employeeIds", required = false ) List<Long> employeeIds,
                         @RequestParam(name = "branchId", required = false ) Long branchId){

        carService.saveCarWithCarKeepersAndBranch(carDTO, employeeIds, branchId);
        return "redirect:/cars";
    }

    @GetMapping("/editCar")
    public String editCarForm(Model model,  @RequestParam(name = "carId") Long carId){

        CarDTO carDTO = carService.findCarById(carId);

        List<EmployeeDTO> employeeDTOS =  employeeService.findAllEmployeesWithCar();

        for ( EmployeeDTO employeeDTO: employeeDTOS) {

            if ( employeeDTO.getCars() !=null && !employeeDTO.getCars().isEmpty()  ) {
                if (employeeDTO.getCars().get(0).getId() != carDTO.getId()){
                    employeeDTO.setCars(null);
                }
            }
        }

        model.addAttribute("car", carDTO);
        model.addAttribute("employees", employeeDTOS);
        model.addAttribute("branches", branchService.findAllBranches());
        return "car-update-form";
    }

}
