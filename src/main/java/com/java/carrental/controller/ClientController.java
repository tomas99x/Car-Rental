package com.java.carrental.controller;

import com.java.carrental.service.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@AllArgsConstructor(onConstructor = @__(@Autowired))
@Controller
public class ClientController {

    ClientService clientService;

    @GetMapping("/clients")
    public String clientList(Model model){
        model.addAttribute("clients", clientService.findAllClients());
        return "client-list";
    }

}
