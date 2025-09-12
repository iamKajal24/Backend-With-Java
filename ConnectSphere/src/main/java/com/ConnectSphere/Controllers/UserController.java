package com.ConnectSphere.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    //user dashboard page
    @GetMapping("/dashboard")
    public String dashboard(){
        System.out.println("dashboard");
        return "user/dashboard";
    }


    //profile page
    @GetMapping("/profile")
    public String profile(){
        System.out.println("profile page");
        return "user/profile";
    }

    //user add contact page

    //user view contacts page
    
}
