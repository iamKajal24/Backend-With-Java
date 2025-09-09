package com.spring1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.spring1.Alien;
import com.spring1.laptop;

@Configuration
@ComponentScan("com.spring1")
public class AppConfig {

   // @Bean("com1")
    // @Bean
    // //@Scope("prototype")
    // public Alien alien(@Qualifier("Alien") Laptop laptop) {
    //     return new Alien(laptop);
    // }

    @Bean
    public Alien alien() {
        return new Alien();
    }


    @Bean
    @Primary
    public laptop laptop() {
        return new laptop();
    }

    //qualifiers mean to differentiate between two same type of beans
     //primary means to give preference to one bean over the other
}

//@component means spring will create the object of that class and manage it
// @Configuration means this class is used for configuration and contains bean methods
//@ComponenetScan("com.spring1") means scan the package com.spring1 for components