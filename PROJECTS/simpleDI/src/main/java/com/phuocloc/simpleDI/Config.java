package com.phuocloc.simpleDI;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    @Bean
    public GreetingService greetingService(){
        return new EnglishGreeting();
    }
}
