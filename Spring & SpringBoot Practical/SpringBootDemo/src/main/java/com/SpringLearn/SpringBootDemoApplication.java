package com.SpringLearn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringBootDemoApplication {

	public static void main(String[] args) {
		// Start the Spring application
		//ApplicationContext means the Spring IoC container
		ApplicationContext context =SpringApplication.run(SpringBootDemoApplication.class, args);
	    System.out.println("Hello, Spring Boot!");

		// Get the Alien bean from the application context
		//getBean() is a method of ApplicationContext
		// Alien alien = new Alien();
		Alien alien = context.getBean(Alien.class);
		alien.code();

		Alien alien1 = context.getBean(Alien.class);
		alien1.code();

		

	}

}
