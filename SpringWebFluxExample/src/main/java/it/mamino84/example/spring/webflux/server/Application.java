package it.mamino84.example.spring.webflux.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.reactive.config.EnableWebFlux;

@SpringBootApplication
@EnableWebFlux
@ComponentScan("it.mamino84.example.spring.webflux.server")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
