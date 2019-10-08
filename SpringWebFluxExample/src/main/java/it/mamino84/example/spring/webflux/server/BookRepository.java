package it.mamino84.example.spring.webflux.server;

import java.util.ArrayList;
import java.util.List;

public class BookRepository {

	public Book findBookByIsbn(String isbn) {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		Book book = new Book();
		book.setIsbn(new Double(Math.random() * 1000).intValue());
		book.setTitle("Inferno");
		book.setAuthor("Dante Alighieri");
		book.setPageNumber(430);

		return book;
	}

	public List<Book> findAllBooks() {
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		List<Book> list = new ArrayList<Book>();

		Book book1 = new Book();
		book1.setIsbn(new Double(Math.random() * 1000).intValue());
		book1.setTitle("Inferno");
		book1.setAuthor("Dante Alighieri");
		book1.setPageNumber(430);
		list.add(book1);
		
		Book book2 = new Book();
		book2.setIsbn(new Double(Math.random() * 1000).intValue());
		book2.setTitle("Purgatorio");
		book2.setAuthor("Dante Alighieri");
		book2.setPageNumber(340);
		list.add(book2);
		
		Book book3 = new Book();
		book3.setIsbn(new Double(Math.random() * 1000).intValue());
		book3.setTitle("Paradiso");
		book3.setAuthor("Dante Alighieri");
		book3.setPageNumber(380);
		list.add(book3);
		
		return list;
	}

}
