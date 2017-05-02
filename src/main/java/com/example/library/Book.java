package com.example.library;

public class Book {

	private long id;
	private String title;
	private String author;
	private String preview;
	private String description;
	
	public Book(long id, String title, String author, String preview, String description) {
		this.id = id;
		this.title = title;
		this.author = author;
		this.preview = preview;
		this.description = description;
	}

	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPreview() {
		return preview;
	}

	public void setPreview(String preview) {
		this.preview = preview;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String toString() {	
		return String.format(
                "Book[id=%d, title='%s', author='%s', preview='%s', description='%s']",
                this.id, this.title, this.author, this.preview, this.description);
	}
}
