package com.spring1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.spring1.config.AppConfig;

public class App {

    public static void main( String[] args )
    {
        
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
      //  Alien a =  context.getBean("com1",Alien.class);
         Alien a =  context.getBean(Alien.class); 
     // a.code();

        Alien a1 =  context.getBean(Alien.class); 
     // a1.code();

        //ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
      //  System.out.println( "Hello World!" );

        //Alien a = new Alien();
        // Alien a = (Alien) context.getBean("alien");
        // a.code();

       // System.out.println(a.getAge());

       //Alien a1 = (Alien) context.getBean("alien");
      // a1.setAge(30);
      // System.out.println(a1.getAge());

       

        // laptop l = (laptop) context.getBean("laptop");
        // l.compile();


        
    }

  

}
