package com.SpringLearn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//@Component means that Spring will manage this class as a bean
@Component
public class Alien {

// @Autowired means that Spring will automatically inject the required dependencies
    @Autowired
    Laptop laptop;

    public void code(){
       laptop.compile();
    }


    
}
