package com.worthen.cody.springnotes.spring_boot.domain;

public class Book {

	private long id;
	private String name;
	private String author;

	public Book(long id, String name, String author) {
		this.id = id;
		this.name = name;
		this.author = author;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getAuthor() {
		return author;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", author=" + author + "]";
	}

}
