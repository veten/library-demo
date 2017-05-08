package com.example.library;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
		if (queryKey.length() == 0) {
			return new ArrayList<LibraryItem>();
		}
		return sortBooksByTitle(getBooksByKey(queryKey));
	}

	private List<LibraryItem> sortBooksByTitle(List<LibraryItem> books) {
		Collections.sort(books, new Comparator<LibraryItem>() {
			@Override
			public int compare(LibraryItem o1, LibraryItem o2) {
				return o1.getVolumeInfo().getTitle().compareTo(o2.getVolumeInfo().getTitle());
			}
		});
		return books;
	}
}
