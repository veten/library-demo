package com.example.library;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.googleapi.LibraryItem;

@Service
public class LibraryService {

	@Autowired
	private LibraryDAO libraryDAO;

	public List<LibraryItem> getBooks(String title, String author) {
		return libraryDAO.getBooks(title, author);
	}

}
