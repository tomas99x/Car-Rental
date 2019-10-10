package com.java.carrental.controller;

import com.java.carrental.constants.ViewNames;
import com.java.carrental.dto.BranchDTO;
import com.java.carrental.service.BranchService;
import com.java.carrental.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@AllArgsConstructor(onConstructor = @__(@Autowired))
@Controller
public class BranchController {

    private BranchService branchService;
    private EmployeeService employeeService;

    @GetMapping("branchList")
    public String branchList(Model model){

        model.addAttribute("branches", branchService.findAllBranches());
        return ViewNames.BRANCH_LIST;
    }

    @GetMapping("viewBranch")
    public String viewBranchForm(Model model, @RequestParam(name="branchId") Long branchId,
                                 @RequestParam(name="branchCity") String branchCity){

        BranchDTO branchDTO = branchService.findBranchById(branchId);
        model.addAttribute("branch", branchDTO);
        model.addAttribute("employees", employeeService.findEmployeesByBranch(branchDTO));
        return ViewNames.BRANCH_VIEW_FORM;
    }
}
