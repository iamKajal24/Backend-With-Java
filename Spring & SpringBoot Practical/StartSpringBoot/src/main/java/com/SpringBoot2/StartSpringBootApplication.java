package com.SpringBoot2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class StartSpringBootApplication {

	public static void main(String[] args) {
	 ApplicationContext context = SpringApplication.run(StartSpringBootApplication.class, args);

         Alien obj = context.getBean(Alien.class);
		 obj.code();
		 System.out.println(obj.getAge());
	}

	
	
   
}
