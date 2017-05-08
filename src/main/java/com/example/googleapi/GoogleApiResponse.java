package com.example.googleapi;

import java.util.List;

import com.example.library.LibraryItem;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GoogleApiResponse {

	private List<LibraryItem> items;
	
	public List<LibraryItem> getItems() {
		return items;
	}

	public void setItems(List<LibraryItem> items) {
		this.items = items;
	}

}