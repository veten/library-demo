package com.example.library;

import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class LibraryDAO {

	private Library library;
	
	public LibraryDAO() {
		this.library = new Library();
		fillLibrary();
	}
	
	private void fillLibrary() {
//		this.library.addToLibrary("eka", new Book("eka kirja"));
//		this.library.addToLibrary("ekaa", new Book("ekaa kirja"));
//		this.library.addToLibrary("toka", new Book("toka kirja"));
	}

	public Book getBookByBookName(String name) {
		if(this.library.getBooks().containsKey(name)) {
			return this.library.getBookByName(name);			
		}
		return null;
	}

	public Map<String,Book> getAllBooks() {
		return this.library.getBooks();
	}

}
