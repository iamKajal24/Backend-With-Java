package com.SpringBoot2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Alien {

    @Value("22")
   private int age;
   private Computer com;

    public void code(){
        com.compile();
    }

    public int getAge() {
         return age;
    }

    public void setAge(int age) {
         this.age = age;
    }

   public Computer getCom() {
       return com;
   }   
   
   @Autowired
   @Qualifier("laptop")
    public void setCom(Computer com) {
         this.com = com;
    }

}
