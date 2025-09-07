package com.spring1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

    public static void main( String[] args )
    {

        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        System.out.println( "Hello World!" );

        //Alien a = new Alien();
        // Alien a = (Alien) context.getBean("alien");
        // a.code();

       // System.out.println(a.getAge());

       Alien a1 = (Alien) context.getBean("alien");
      // a1.setAge(30);
       System.out.println(a1.getAge());

       

        laptop l = (laptop) context.getBean("laptop");
        l.compile();


        
    }
    
}
