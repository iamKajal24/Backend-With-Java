package com.ConnectSphere.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ConnectSphere.entities.User;
import com.ConnectSphere.forms.UserForm;
import com.ConnectSphere.helpers.Message;
import com.ConnectSphere.helpers.MessageType;
import com.ConnectSphere.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;


@Controller
public class PageController {

    @Autowired
    private UserService userService;

     @GetMapping("/")
    public String index() {
        return "redirect:/home";
    }

    //home route
    @RequestMapping("/home")
    public String home(){
        System.out.println("Home Page Handler");
        return "home";
    }


    //about handler

    @RequestMapping("/about")
    public String about(){
        System.out.println("About page handler");
        return "about";
    }


    //service handler
    @RequestMapping("/service")
    public String service(){
        System.out.println("service page handler");
        return "service";
    }

    // contact handler
    @RequestMapping("/contact")
    public String contact(){
        System.out.println("Contact page handler");
        return "contact";
    }

    // login handler
    @RequestMapping("/login")
    public String login(){
        System.out.println("Login page handler");
        return "login";
    }


    //sign up handler
    @RequestMapping("/register")
    public String register(Model model){
        System.out.println("Sign up page handler");
        UserForm userForm =  new UserForm();
        model.addAttribute("userForm" , userForm);
       // userForm.setName("kajal");
        return "register";
    }

    //processing register
     @RequestMapping(value="/do-register", method=RequestMethod.POST)
    public String processRegister(@Valid @ModelAttribute UserForm userForm,BindingResult rBindingResult ,HttpSession session){
        System.out.println("processing register");
        
        //fetch from data
        System.out.println(userForm);

        //validate form data
        if(rBindingResult.hasErrors()){
            return "register";
        }

        //save to database
        // User user = User.builder()
        // .name(userForm.getName())
        // .email(userForm.getEmail())
        // .password(userForm.getPassword())
        // .about(userForm.getAbout())
        // .phoneNumber(userForm.getPhoneNumber())
        // .profilePic("default.jpg")
        // .build();

        User user = new User();
        user.setName(userForm.getName());
        user.setEmail(userForm.getEmail());
        user.setPassword(userForm.getPassword());
        user.setAbout(userForm.getAbout());
        user.setPhoneNumber(userForm.getPhoneNumber());
        user.setEnabled(false);
        user.setProfilePic("default.jpg");


       User savedUser =userService.saveUser(user);
       System.out.println("user saved :");

        //message = "Registeration successful"

        Message message = Message.builder().content("Registration Successful").type(MessageType.green).build();
        session.setAttribute("message", message);

        return "redirect:/register";
    }

    
}
