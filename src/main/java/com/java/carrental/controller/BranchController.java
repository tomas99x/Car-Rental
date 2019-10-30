package com.java.carrental.controller;

import com.java.carrental.constants.ViewNames;
import com.java.carrental.dto.AddressDTO;
import com.java.carrental.dto.BranchDTO;
import com.java.carrental.service.BranchService;
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
public class BranchController {

    private BranchService branchService;
    private EmployeeService employeeService;

    @GetMapping("branchList")
    public String branchList(Model model){

        model.addAttribute("branches", branchService.findAllBranches());
        return ViewNames.BRANCH_LIST;
    }

    @GetMapping("viewBranch")
    public String viewBranchForm(@RequestParam(name="branchId") Long branchId, Model model){

        BranchDTO branchDTO = branchService.findBranchById(branchId);
        model.addAttribute("branch", branchDTO);
        model.addAttribute("employees", employeeService.findEmployeesByBranch(branchDTO));
        return ViewNames.BRANCH_VIEW_FORM;
    }

    @GetMapping("/addBranch")
    public String branchForm(Model model){
        BranchDTO branchDTO = new BranchDTO();
        branchDTO.setAddress(new AddressDTO());
        model.addAttribute("branch", branchDTO);
        return ViewNames.BRANCH_ADD_FORM;
    }

    @PostMapping("/addBranch")
    public String addBranchForm(@ModelAttribute("branch") @Valid BranchDTO branchDTO,
                                BindingResult bindingResult, Model model){

        if (bindingResult.hasErrors()){
            if (branchDTO.getId() == null){
                return ViewNames.BRANCH_ADD_FORM;
            } else {
                return ViewNames.BRANCH_UPDATE_FORM;
            }
        }
        branchService.saveBranch(branchDTO);
        return "redirect:/branchList";
    }

    @GetMapping("/editBranch")
    public String editBranchForm(@RequestParam(name = "branchId") Long branchId, Model model){
        model.addAttribute("branch", branchService.findBranchById(branchId));
        return ViewNames.BRANCH_UPDATE_FORM;
    }
}
