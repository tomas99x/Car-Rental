package com.java.carrental.controller;

import com.java.carrental.constants.ViewNames;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/")
    public String showIndexPage(){
       return ViewNames.INDEX;
    }

}
