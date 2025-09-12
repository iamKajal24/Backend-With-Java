// package com.ConnectSphere.Config;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;

// import org.springframework.security.authentication.dao.DaoAuthenticationProvider;

// import org.springframework.security.config.annotation.web.builders.HttpSecurity;

// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.security.web.SecurityFilterChain;


// import com.ConnectSphere.services.Impl.SecurityCustomUserDetailService;

// @Configuration
// public class SecurityConfig {

//     @Autowired
//     private SecurityCustomUserDetailService userDetailService;

//     // Define a PasswordEncoder Bean
//     @Bean
//     public PasswordEncoder passwordEncoder() {
//         return new BCryptPasswordEncoder();
//     }

//     // Define In-Memory UserDetailsService Bean
//     // @Bean
//     // public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {
//     //     UserDetails user = User.builder()
//     //             .username("admin")
//     //             .password(passwordEncoder.encode("admin123"))
//     //             .roles("ADMIN","USER")
//     //             .build();

//     //     UserDetails user1 = User.builder()
//     //             .username("user")
//     //             .password(passwordEncoder.encode("user123"))
//     //             .roles("ADMIN","USER")
//     //             .build();

//     //     return new InMemoryUserDetailsManager(user,user1);
//     // }


//     //configuration of authentication provider
    
//     @Bean
//     public DaoAuthenticationProvider authenticationProvider(){
//         DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
//         daoAuthenticationProvider.setUserDetailsService(userDetailService);
//         daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        
//         return daoAuthenticationProvider;

//     }

//     //security filter chain

//     @Bean
//     public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
       
//         httpSecurity.authorizeHttpRequests(authorize -> {
//             // authorize.requestMatchers("/home", "/register", "/services").permitAll();
//             authorize.requestMatchers("/user/**").authenticated();
//             authorize.anyRequest().permitAll();
//         });

//         // //form login
//         // httpSecurity.formLogin(Customizer.withDefaults());

//        httpSecurity.formLogin(formLogin -> {
//        formLogin
//         .loginPage("/login")
//         .loginProcessingUrl("/authenticate")
//         .defaultSuccessUrl("/user/dashboard", true) // ✅ redirect after successful login
//         .failureUrl("/login?error=true")
//         .usernameParameter("email")
//         .passwordParameter("password");
//        });


            
       
//         return httpSecurity.build();

//     }

// }
