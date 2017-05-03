package com.example.library;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Library {

	private List<Book> listOfBooks;
	private Map<String, List<Book>> titleMap;
	private Map<String, List<Book>> authorMap;

	public Library() {
		this.listOfBooks = new ArrayList<>();
		this.titleMap = new HashMap<>();
		this.authorMap = new HashMap<>();
	}

	public void addBookToLibrary(Book book) {
		this.listOfBooks.add(book);
		if (this.authorMap.containsKey(book.getAuthor())) {
			this.authorMap.get(book.getAuthor()).add(book);
		} else {
			ArrayList<Book> newList = new ArrayList<>();
			newList.add(book);
			this.authorMap.put(book.getAuthor(), newList);
		}
		if (this.titleMap.containsKey(book.getTitle())) {
			this.titleMap.get(book.getTitle()).add(book);
		} else {
			ArrayList<Book> newList = new ArrayList<>();
			newList.add(book);
			this.titleMap.put(book.getTitle(), newList);
		}
	}

	public List<Book> getListOfBooks() {
		return this.listOfBooks;
	}

	public List<Book> getBooksByTitle(String title) {
		return this.titleMap.get(title);
	}

	public List<Book> getBooksByAuthor(String author) {
		return this.titleMap.get(author);
	}

}