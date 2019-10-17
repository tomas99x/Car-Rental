package com.java.carrental.controller;

import com.java.carrental.constants.ViewNames;
import com.java.carrental.dto.ClientDTO;
import com.java.carrental.service.ClientService;
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
public class ClientController {

    ClientService clientService;

    @GetMapping("/clientList")
    public String clientList(Model model){
        model.addAttribute("clients", clientService.findAllClients());
        return ViewNames.CLIENT_LIST;
    }

    @GetMapping("/viewClient")
    public String viewClientForm(Model model, @RequestParam(name = "clientId") Long clientId){
        model.addAttribute("client", clientService.findClientById(clientId));
        model.addAttribute("rentals", clientService.findClientRentals(clientId));
        return ViewNames.CLIENT_VIEW_FORM;
    }

    @GetMapping("/addClient")
    public String clientForm(Model model){
        model.addAttribute("client", new ClientDTO());
        return ViewNames.CLIENT_ADD_FORM;
    }

    @PostMapping("/addClient")
    public String addClientForm(@ModelAttribute("client") @Valid ClientDTO clientDTO,
                                BindingResult bindingResult, Model model){

        if(bindingResult.hasErrors()){
            return ViewNames.CLIENT_ADD_FORM;
        }

        clientService.addClient(clientDTO);
        model.addAttribute("clients", clientService.findAllClients());
        return ViewNames.CLIENT_LIST;
    }

    @GetMapping("/editClient")
    public String editClientForm(Model model, @RequestParam(name = "clientId") Long clientId){

        model.addAttribute("client", clientService.findClientById(clientId));
        return ViewNames.CLIENT_UPDATE_FORM;
    }

    //TODO implement searchClient method
    public String searchClient() {
        return null;
    }
}
