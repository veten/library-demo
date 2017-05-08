package com.example.library;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.googleapi.GoogleAPIReader;

@Component
public class LibraryDAO {

	@Autowired
	private GoogleAPIReader reader;

	private List<LibraryItem> getBooksByKey(String queryKey) {
		return this.reader.getGoogleApiResponse(queryKey).getItems();
	}

	public List<LibraryItem> getBooks(String title, String author) {
		String queryKey = "";
		if (author != null & author.length() > 0) {
			queryKey += "inauthor:" + author;
		}
		if (title != null && title.length() > 0) {
			queryKey += " intitle:" + title;
		}
		return getBooksByKey(queryKey);
	}

}
