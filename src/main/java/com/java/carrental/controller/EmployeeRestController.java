package com.java.carrental.controller;

import com.java.carrental.dto.EmployeeDTO;
import com.java.carrental.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeRestController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/api/employees")
    public ResponseEntity<List<EmployeeDTO>> findAllEmployees() {
        List<EmployeeDTO> allCars = employeeService.findAllEmployees();
        return ResponseEntity.ok().body(allCars);
    }

    @GetMapping("/api/employee/{id}")
    public ResponseEntity<EmployeeDTO> findEmployee(@PathVariable("id") Long id) {
        if (id < 0) {
            return ResponseEntity.badRequest().body(null);
        }
        EmployeeDTO employeeDTO = employeeService.findEmployeeById(id);
        return ResponseEntity.ok().body(employeeDTO);
    }

    @GetMapping("/api/employeeCar/{id}")
    public ResponseEntity<EmployeeDTO> findEmployeeWithCar(@PathVariable("id") Long id) {
        if (id < 0) {
            return ResponseEntity.badRequest().body(null);
        }
        EmployeeDTO employeeDTO = employeeService.findEmployeeByIdWithCar(id);
        return ResponseEntity.ok().body(employeeDTO);
    }

}
