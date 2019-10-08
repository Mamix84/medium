package it.mamino84.example.spring.webflux.client;

import org.springframework.stereotype.Controller;
import org.springframework.web.reactive.function.client.WebClient;

import it.mamino84.example.spring.webflux.server.Book;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Controller
public class WebClientCaller {

	public WebClientCaller() {
		super();
		init();
	}

	public void init() {
		WebClient client = WebClient.create("http://localhost:8080");

		Mono<Book> mono = client.get().uri("/books/{isbn}", "1").retrieve().bodyToMono(Book.class);
		mono.subscribe(System.out::println);

		Flux<Book> flux = client.get().uri("/books").retrieve().bodyToFlux(Book.class);
		flux.subscribe(System.out::println);

		System.out.println("Finish method");

	}

}
