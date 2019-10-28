package com.java.carrental.controller;

import com.java.carrental.constants.ViewNames;
import com.java.carrental.dto.CarDTO;
import com.java.carrental.dto.EmployeeDTO;
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
import java.util.List;

@AllArgsConstructor(onConstructor = @__(@Autowired))
@Controller
public class EmployeeController {

    EmployeeService employeeService;
    BranchService branchService;
    CarService carService;

    @GetMapping("/employeeList")
    public String listCars(Model model){
        model.addAttribute("employees", employeeService.findAllEmployees());
        return ViewNames.EMPLOYEE_LIST;
    }

    @GetMapping("/viewEmployee")
    public String viewEmployeeForm(@RequestParam(name = "employeeId") Long employeeId, Model model){
        model.addAttribute("employee", employeeService.findEmployeeById(employeeId));
        return ViewNames.EMPLOYEE_VIEW_FORM;
    }

    //TODO implement addEmployeeForm method
    @GetMapping("/addEmployee")
    public String employeeForm(Model model){

        model.addAttribute("employee", new EmployeeDTO());
        model.addAttribute("branchesAllValues", branchService.findAllBranches());

        return ViewNames.EMPLOYEE_ADD_FORM;
    }

    @PostMapping("/addEmployee")
    public String addEmployeeForm(@ModelAttribute("employee") @Valid EmployeeDTO employeeDTO,
                                  BindingResult bindingResult, Model model,
                                  @RequestParam(name = "employeeAction", required = true) String employeeAction){

        if(bindingResult.hasErrors()){

            model.addAttribute("branchesAllValues", branchService.findAllBranches());
            return ViewNames.EMPLOYEE_ADD_FORM;
        }

        if ("actionSearchCar".equals(employeeAction)){
            List<CarDTO> carDTOS =  carService.findCarByModelTypeBranch(null, null, employeeDTO.getBranch().getId().toString() );
            model.addAttribute("carsAll", carDTOS);
            model.addAttribute("branchesAllValues", branchService.findAllBranches());
            return ViewNames.EMPLOYEE_ADD_FORM;
        }

        employeeService.addEmployee(employeeDTO);
        return "redirect:/employeeList";
    }

    //TODO implement editEmployeeForm method
    public String editEmployeeForm(){
        return null;
    }


}
