package com.wildcodeschool.myProjectWithSecurity.config;

import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;



@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

  @Override
  protected void configure(HttpSecurity http) throws Exception {
      http
        .authorizeRequests()
           //.anyRequest().authenticated()
           .antMatchers("/admin").hasRole("ADMIN")
           .antMatchers("/avengers/assemble").hasRole("HERO")
           .antMatchers("/secret-bases").hasRole("DIRECTOR")
           .antMatchers("/test").hasRole("TEST")
           .and()
         .formLogin()
             .and()
          .httpBasic();
  }

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
    auth.inMemoryAuthentication()
        .withUser("user").password(encoder.encode("a")).roles("DIRECTOR","HERO").and()
        .withUser("steve").password(encoder.encode("a")).roles("HERO")      .and()
        .withUser("tony").password(encoder.encode("a")).roles("HERO")       .and()
        .withUser("nick").password(encoder.encode("a")).roles("DIRECTOR")   .and()
        .withUser("test").password(encoder.encode("a")).roles("TEST")       .and()
        .withUser("admin").password(encoder.encode("admin")).roles("DIRECTOR","ADMIN","HERO","TEST")
    ;
  }

}
