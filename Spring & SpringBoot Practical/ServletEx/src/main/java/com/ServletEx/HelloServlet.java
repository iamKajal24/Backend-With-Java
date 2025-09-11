package com.ServletEx;

import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
    
    public void service(HttpServletRequest req,HttpServletResponse res){
        System.out.println("Inside Service Method");
    }
   
    
}
