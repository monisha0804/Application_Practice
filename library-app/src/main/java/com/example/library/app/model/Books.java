package com.example.library.app.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "Catalog")
public class Books {
	@Id
	private String id;
	@Field
	private String title;
	@Field
	private String genre;
	@Field
	private String author;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public Books(String id, String title, String genre, String author) {
		super();
		this.id = id;
		this.title = title;
		this.genre = genre;
		this.author = author;
	}
	@Override
	public String toString() {
		return "Books [id=" + id + ", title=" + title + ", genre=" + genre + ", author=" + author + "]";
	}
	
	
	
}
