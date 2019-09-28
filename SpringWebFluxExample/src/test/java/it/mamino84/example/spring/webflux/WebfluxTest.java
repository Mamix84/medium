package it.mamino84.example.spring.webflux;

import org.springframework.web.reactive.function.client.WebClient;

import it.mamino84.example.spring.webflux.server.Employee;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class WebfluxTest {

	public static void main(String[] args) {
		WebClient client = WebClient.create("http://localhost:8080");

		Mono<Employee> employeeMono = client.get().uri("/employees/{id}", "1").retrieve().bodyToMono(Employee.class);
		employeeMono.subscribe(System.out::println);

		Flux<Employee> employeeFlux = client.get().uri("/employees").retrieve().bodyToFlux(Employee.class);
		employeeFlux.subscribe(System.out::println);

		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println(employeeMono);
		
	}

}
