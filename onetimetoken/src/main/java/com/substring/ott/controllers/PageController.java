package com.substring.ott.controllers;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

    @RequestMapping("/home")
    public String home(){
        return "home";
    }

    @RequestMapping("/ott/sent")
    public String ottSentSuccessMessage(){
        return "ott-sent";
    }

    @RequestMapping("/dashboard")
    public String dashboard(Principal principal,Model model){
        model.addAttribute("user", principal.getName());
        return "dashboard";
    }
    
}
