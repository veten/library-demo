package com.example.library;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LibraryRestController {

	@Autowired
	private LibraryService service;

	@RequestMapping("/author")
	public List<Book> byAuthor(@RequestParam(value = "author") String author) {
		return service.getBooksByAuthor(author);
	}

	@RequestMapping("/title")
	public List<Book> byTitle(@RequestParam(value = "title") String title) {
		return service.getBooksByTitle(title);
	}

	@RequestMapping("/books")
	public List<Book> library() {
		return service.getBooks();
	}
}
