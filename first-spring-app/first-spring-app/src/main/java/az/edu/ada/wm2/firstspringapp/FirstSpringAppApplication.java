package az.edu.ada.wm2.firstspringapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RestController
public class FirstSpringAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirstSpringAppApplication.class, args);
	}

	public String sayHello(){
		return "Hi there";
	}

}
