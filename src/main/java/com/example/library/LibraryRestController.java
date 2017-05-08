package com.example.library;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LibraryRestController {

	@Autowired
	private LibraryService service;

	@RequestMapping("/books")
	public List<LibraryItem> byBoth(@RequestParam(value = "title", required = false) String title,
			@RequestParam(value = "author", required = false) String author) {
		return service.getBooks(title, author);
	}

}
