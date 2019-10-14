package com.java.carrental.controller;

import com.java.carrental.constants.ViewNames;
import com.java.carrental.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/employeeList")
    public String listCars(Model model){
        model.addAttribute("employees", employeeService.findAllEmployees());
        return ViewNames.EMPLOYEE_LIST;
    }

    //TODO implement viewEmployeeForm method
    public String viewEmployeeForm(){
        return null;
    }

    //TODO implement addEmployeeForm method
    public String addEmployeeForm(){
        return null;
    }

    //TODO implement editEmployeeForm method
    public String editEmployeeForm(){
        return null;
    }


}
