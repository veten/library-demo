package com.example.library;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class LibraryDAO {

	private Library library;
	private InMemoryDB db;
	
	public LibraryDAO() {
//		this.db = new InMemoryDB();
		this.library = new Library();
		fillLibrary();
	}
	
	private void fillLibrary() {
		this.library.addBookToLibrary(new Book(1, "On Writing","Stephen King","http://books.google.fi/books?id=d999Z2KbZJYC&printsec=frontcover&dq=Stephen+King&hl=&cd=1&source=gbs_api","The author shares his insights into the craft of writing and offers a humorous perspective on his own experience as a writer."));
		this.library.addBookToLibrary(new Book(2, "Carrie","Stephen King","http://books.google.fi/books?id=FNxGvn1SCVMC&printsec=frontcover&dq=Stephen+King&hl=&cd=2&source=gbs_api","Stephen King's legendary debut, about a teenage outcast and the revenge she enacts on her classmates. Carrie White may be picked on by her classmates, but she has a gift."));
		this.library.addBookToLibrary(new Book(3, "Kolmas kirja","kuka lie","linkki","kuvaus"));
	}

	public List<Book> getBooksByTitle(String title) {
		return this.library.getBooksByTitle(title);
	}

	public List<Book> getBooksByAuthor(String author) {
		return this.library.getBooksByAuthor(author);
	}

	
	public List<Book> getAllBooks() {
		return this.library.getListOfBooks();
	}

}
