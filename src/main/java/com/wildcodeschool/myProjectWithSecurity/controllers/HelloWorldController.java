package com.wildcodeschool.myProjectWithSecurity.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @GetMapping("/")
    public String hello() {        
        return "Hello World " 
        + "<br> " 
        + " <a href=/test>test </a>  " 
        + "<br> " 
        + " <a href=/avengers/assemble>assemble </a>  "
        + "<br> " 
        + " <a href=/secret-bases>secret-bases </a>  "
        + "<br> " 
        + "  <a href=/logout>logout </a> ";
    }

    @GetMapping("/test")
    public String test() {
        return " test  <a href=/logout>logout  </a>  ";
    }

    @GetMapping("/admin")
    public String admin() {
        return " admin  <a href=/logout>logout  </a>  ";
    }

    @GetMapping("/avengers/assemble")
    public String assemble() {
        return " Avengers..... Assemble "
                + "<br> " 
                + " <a href=/>base </a>  " 
                + "<br> " 
                + " <a href=/test>test </a>  " 
                + "<br> " 
                + " <a href=/secret-bases>secret-bases </a>  "
                + "<br> " 
                + "  <a href=/logout>logout  </a>  ";
    }

    @GetMapping("/secret-bases")
    public String bases() {
        return  " Darmstadt " 
                + "<br> " 
                + " Berlin "
                + "<br> " 
                + " <a href=/>base </a>  "
                + "<br> " 
                + " <a href=/test>test </a>  " 
                + "<br> " 
                + " <a href=/avengers/assemble>assemble </a>  " 
                + "<br> "  
                + " <a href=/logout>logout  </a>  ";
    }
}
