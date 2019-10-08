package it.mamino84.example.spring.webflux;

import org.springframework.web.reactive.function.client.WebClient;

import it.mamino84.example.spring.webflux.server.Book;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class WebfluxTest {

	public static void main(String[] args) {
		WebClient client = WebClient.create("http://localhost:8080");

		Mono<Book> mono = client.get().uri("/books/{id}", "1").retrieve().bodyToMono(Book.class);
		mono.subscribe(System.out::println);

		Flux<Book> flux = client.get().uri("/books").retrieve().bodyToFlux(Book.class);
		flux.subscribe(System.out::println);

		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println(mono);
		
	}

}
