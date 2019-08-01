package com.luanphm.CourseManagement.configuration.security_configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    @Qualifier("userDetailServiceImpl")
    private UserDetailsService userDetailService;


    @Bean
    public PasswordEncoder passwordEncoder() {
        System.out.println("WebSecurityConfig: passwordEncoder()");
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        System.out.println("WebSecurityConfig: configure(AuthenticationManagerBuilder auth)");
        auth.userDetailsService(userDetailService).passwordEncoder(passwordEncoder());
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
//        System.out.println("WebSecurityConfig: configure(WebSecurity web)");
        super.configure(web);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        System.out.println("WebSecurityConfig: configure(HttpSecurity http)");
        http.csrf().disable()
                .authorizeRequests()
                    .antMatchers("/login").permitAll()
                    .antMatchers("/api/users/").permitAll()
//                    .antMatchers("/api/**").hasAnyRole("INSTRUCTOR", "ADMIN")
                    .anyRequest()
                    .authenticated()
                .and()
                    .addFilterBefore(new JwtLoginFilter("/login", authenticationManager()),UsernamePasswordAuthenticationFilter.class)
                    .addFilterBefore(new JwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
    }
}






































