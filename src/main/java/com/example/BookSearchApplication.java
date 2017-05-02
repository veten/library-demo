package com.example;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import com.example.library.Book;

@SpringBootApplication
public class BookSearchApplication implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(BookSearchApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookSearchApplication.class, args);
	}

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public void run(String... strings) throws Exception {

		log.info("Creating tables");

		jdbcTemplate.execute("DROP TABLE books IF EXISTS");
		jdbcTemplate.execute("CREATE TABLE books("
				+ "id SERIAL, title VARCHAR(255), author VARCHAR(255), preview VARCHAR(255), description VARCHAR(255))");

		List<Object[]> splitUpBookData = Arrays
				.asList("On Writing;Stephen King;http://books.google.fi/books?id=d999Z2KbZJYC&printsec=frontcover&dq=Stephen+King&hl=&cd=1&source=gbs_api;The author shares his insights into the craft of writing and offers a humorous perspective on his own experience as a writer.",
						"Carrie;Stephen King;http://books.google.fi/books?id=FNxGvn1SCVMC&printsec=frontcover&dq=Stephen+King&hl=&cd=2&source=gbs_api;Stephen King's legendary debut, about a teenage outcast and the revenge she enacts on her classmates. Carrie White may be picked on by her classmates, but she has a gift.")
				.stream().map(book -> book.split(";")).collect(Collectors.toList());

		splitUpBookData.forEach(book -> log.info(String.format("Inserting book record for %s %s %s %s", book[0], book[1], book[2], book[3])));

		jdbcTemplate.batchUpdate("INSERT INTO books(title, author, preview, description) VALUES (?,?,?,?)", splitUpBookData);

		log.info("Querying for book records where title = 'Carrie':");
		jdbcTemplate
				.query("SELECT id, title, author, preview, description FROM books WHERE title = ?",
						new Object[] { "Carrie" }, (rs, rowNum) -> new Book(rs.getLong("id"),
								rs.getString("title"), rs.getString("author"), rs.getString("preview"), rs.getString("description")))
				.forEach(book -> log.info(book.toString()));
	}
}
