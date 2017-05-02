package com.example.library;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LibraryRestController {

	@Autowired
	private LibraryService service;
	
	@RequestMapping("/book")
    public Book book(@RequestParam(value="name") String name) {
        return service.getBook(name);
    }
	
	@RequestMapping("/books")
    public Map<String,Book> library() {
        return service.getBooks();
    }
}
