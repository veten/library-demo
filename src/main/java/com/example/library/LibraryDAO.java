package com.example.library;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.googleapi.GoogleAPIReader;
import com.example.googleapi.LibraryItem;

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
		if(queryKey.length() == 0) {
			return new ArrayList<LibraryItem>();
		}
		return getBooksByKey(queryKey);
	}

}
