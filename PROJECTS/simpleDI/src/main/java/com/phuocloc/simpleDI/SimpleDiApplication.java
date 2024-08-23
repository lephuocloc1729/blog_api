package com.phuocloc.simpleDI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.phuocloc")
public class SimpleDiApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SimpleDiApplication.class, args);
//		ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
		UserController userController = context.getBean(UserController.class);
		userController.displayGreeting();
	}

}
