package com.empowerpeers;

/**
 * Bootstrap the Application
 * Optional init scripts in CommandLineRunner
 * @author Dave
 */
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
  
	public static void main(String[] args) {
		SpringApplication.run(Application.class); 
	}
}