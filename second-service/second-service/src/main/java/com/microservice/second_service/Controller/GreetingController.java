package com.microservice.second_service.Controller;

import com.microservice.second_service.Service.Greeting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
    @Autowired
    Greeting greet;
    @GetMapping("/")
    public Greeting getGreeting(){

        return new Greeting(greet.getFirst(),greet.getLast());
    }
    @GetMapping("/first")
    public String getData(){
        return "welcome to coding !";
    }
}

