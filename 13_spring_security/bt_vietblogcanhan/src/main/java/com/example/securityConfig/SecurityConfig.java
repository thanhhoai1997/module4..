package com.example.securityConfig;

import com.example.service.user.BlogUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
//    @Autowired
//    private BlogUserDetailService blogUserDetailService;
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/blog","/blog/{id}/view","/blog/user/{id}").permitAll()
                .anyRequest().authenticated().and()
                .formLogin().loginPage("/blog/login").permitAll()
                .defaultSuccessUrl("/blog")
                .failureUrl("/blog/login?error=true")
                .usernameParameter("username1")
                .passwordParameter("password1")
                .loginProcessingUrl("/j_spring_security_check")
                .and()
                .logout().logoutUrl("/blog/logout")
        ;

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("user1").password(passwordEncoder().encode("123"))
//                .authorities("USER_ADMIN");
        auth.userDetailsService(new BlogUserDetailService()).passwordEncoder(passwordEncoder());

    }
}
