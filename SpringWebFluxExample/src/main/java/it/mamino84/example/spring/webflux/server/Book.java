package it.mamino84.example.spring.webflux.server;

import java.util.Date;

public class Book {

	private int isbn;
	private String title;
	private String author;
	private int pageNumber;

	public Book() {
		super();
	}

	public Book(String title, String author, int pageNumber) {
		super();
		this.title = title;
		this.author = author;
		this.pageNumber = pageNumber;
	}

	public int getIsbn() {
		return isbn;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public String toString() {
		return "[" + new Date() + "] - ISBN: " + isbn + " - Title: " + title + " - Author: " + author
				+ " - Page number: " + pageNumber;
	}

}
