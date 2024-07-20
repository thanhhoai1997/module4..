//package com.example.furama.securityConfig;
//
//import com.example.furama.service.security.CustomUserDetailsService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//    @Autowired
//    private CustomUserDetailsService customUserDetailsService;
//    @Bean

//    BCryptPasswordEncoder passwordEncoder(){
//        return new BCryptPasswordEncoder();
//    }
//
//    @Bean
//    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
//            http.csrf(csrf-> csrf.disable())
//                    .authorizeHttpRequests((auth)->auth
//
//                            .requestMatchers("/employee/create","/employee/delete/**","/employee/edit/**")
//                            .hasAnyAuthority("MANAGER","MANAGE")
//                            .anyRequest().authenticated())
//                    .formLogin(login->login.loginPage("/login").permitAll()
//                            .loginProcessingUrl("/login")
//                            .usernameParameter("username")
//                            .passwordParameter("password")
//                            .defaultSuccessUrl("/")
//                            .failureUrl("/login?error=true"))
//
//            ;
//
//
//
//
//
//        return http.build();
//
//    }
//}
