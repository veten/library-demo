package com.example.library;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LibraryService {

	@Autowired
	private LibraryDAO libraryDAO;
	
	public List<Book> getBooksByTitle(String title) {
		return libraryDAO.getBooksByTitle(title);
	}

	public List<Book> getBooksByAuthor(String author) {
		return libraryDAO.getBooksByAuthor(author);
	}
	
	public List<Book> getBooks() {
		return libraryDAO.getAllBooks();
	}

}
