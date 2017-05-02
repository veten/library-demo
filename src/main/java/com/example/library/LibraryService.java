package com.example.library;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LibraryService {

	@Autowired
	private LibraryDAO libraryDAO;
	
	public Book getBook(String name) {
		return libraryDAO.getBookByBookName(name);
	}

	public Map<String,Book> getBooks() {
		return libraryDAO.getAllBooks();
	}

}
