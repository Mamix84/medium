package it.mamino84.dor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("it.mamino84.dor")
public class DomOverRestProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(DomOverRestProjectApplication.class, args);
	}

}
