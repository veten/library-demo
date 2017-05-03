package com.example.library;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;


public class InMemoryDB {

	@Autowired
	JdbcTemplate jdbcTemplate;

	private static final Logger log = LoggerFactory.getLogger(InMemoryDB.class);

	
	public InMemoryDB() {
	}
	
	public Map<String,Book> getAllBooks() {
		Map<String, Book> books = new HashMap<>();
		log.info("Querying for book records where title = 'Carrie':");
		jdbcTemplate
				.query("SELECT id, title, author, preview, description FROM books WHERE title = ?",
						new Object[] { "Carrie" }, (rs, rowNum) -> new Book(rs.getLong("id"),
								rs.getString("title"), rs.getString("author"), rs.getString("preview"), rs.getString("description")))
				.forEach(book -> books.put(book.getTitle(), book));
		return books;
	}
	
	public Map<String, Book> getBooksByTitle(String title) {
		Map<String, Book> books = new HashMap<>();
		log.info("Querying for book records where title = '{}':", title);
		jdbcTemplate
				.query("SELECT id, title, author, preview, description FROM books WHERE title = ?",
						new Object[] { title }, (rs, rowNum) -> new Book(rs.getLong("id"),
								rs.getString("title"), rs.getString("author"), rs.getString("preview"), rs.getString("description")))
				.forEach(book -> books.put(book.getTitle(), book));
		return books;
	}
	
	
}
