package it.mamino84.example.spring.webflux.server;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/books")
public class BookController {

	private final BookRepository bookRepository;

	public BookController() {
		bookRepository = new BookRepository();
	}

	@GetMapping("/{isbn}")
	private Mono<Book> getBookByIsbn(@PathVariable String isbn) {

		Book book = bookRepository.findBookByIsbn(isbn);

		Mono<Book> just = Mono.just(book);

		return just;
	}

	@GetMapping
	private Flux<Object> getAllBooks() {
		List<Book> list = bookRepository.findAllBooks();
		
		Flux<Object> just = Flux.fromArray(list.toArray());
		
		return just;		
	}
}