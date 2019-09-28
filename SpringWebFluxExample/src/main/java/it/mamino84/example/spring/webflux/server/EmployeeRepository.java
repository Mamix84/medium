package it.mamino84.example.spring.webflux.server;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class EmployeeRepository {

	public Mono<Employee> findEmployeeById(String id) {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		Employee employee = new Employee();
		employee.setName("Marco");
		employee.setSurname("Marino");

		Mono<Employee> just = Mono.just(employee);

		return just;
	}

	public Flux<Employee> findAllEmployees() {
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		Employee employee1 = new Employee();
		employee1.setName("Marco");
		employee1.setSurname("Marino");

		Employee employee2 = new Employee();
		employee2.setName("Samuel");
		employee2.setSurname("Marino");

		Employee employee3 = new Employee();
		employee3.setName("Elia");
		employee3.setSurname("Marino");

		Flux<Employee> just = Flux.just(employee1, employee2, employee3);

		return just;
	}

}
