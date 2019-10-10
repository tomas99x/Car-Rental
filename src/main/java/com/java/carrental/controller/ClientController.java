package com.java.carrental.controller;

import com.java.carrental.service.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@AllArgsConstructor(onConstructor = @__(@Autowired))
@Controller
public class ClientController {

    ClientService clientService;

    @GetMapping("/clientList")
    public String clientList(Model model){
        model.addAttribute("clients", clientService.findAllClients());
        return "client-list";
    }

    @GetMapping("/viewClient")
    public String viewCarForm(Model model, @RequestParam(name = "clientId") Long clientId){
        model.addAttribute("client", clientService.findClientById(clientId));
        model.addAttribute("rentals", clientService.findClientRentals(clientId));
        return "client-view-form";
    }

}
