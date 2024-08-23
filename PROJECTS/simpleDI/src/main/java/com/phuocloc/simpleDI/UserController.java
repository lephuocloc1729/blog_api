package com.phuocloc.simpleDI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserController {
    private final GreetingService greetingService;

    @Autowired
    public UserController(GreetingService greetingService){
        this.greetingService = greetingService;
    }

    public void displayGreeting(){
        greetingService.greet();
    }
}
