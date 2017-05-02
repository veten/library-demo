package com.example.library;

import java.util.HashMap;
import java.util.Map;

public class Library {

	private Map<String,Book> books;
	
	public Library() {
		this.books = new HashMap<>();
	}
	
	public void addToLibrary(String key, Book value) {
		this.books.put(key, value);
	}

	public Map<String,Book> getBooks() {
		return books;
	}
	
	@Override
	public String toString() {		
		return this.books.toString();
	}

	public Book getBookByName(String name) {
		return this.books.get(name);
	}
}
