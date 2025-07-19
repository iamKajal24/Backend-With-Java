package com.substring.ott.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user1 = User.withUsername("kajal")
                                .password("{noop}kajal") // {noop} means no password encoding
                                .roles("USER")           // add a role if needed
                                .build();

        return new InMemoryUserDetailsManager(user1);
    }


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
       httpSecurity.authorizeHttpRequests(request->{
                request.requestMatchers("/dashboard").authenticated().anyRequest().permitAll();
       });

       httpSecurity.formLogin(Customizer.withDefaults())
       .oneTimeTokenLogin(Customizer.withDefaults());

        return httpSecurity.build();
    }
}
