package com.worthen.cody.springnotes.RESTservice.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.worthen.cody.springnotes.RESTservice.domain.Book;

@RestController // @RequestMapping methods assume @ResponseBody semantics by default
public class BookController {

	/**
	 * http://localhost:8080/books
	 * 
	 * This is a REST service that returns a list of books in JSON format.
	 */

	@GetMapping("/books") // maps a GET url
	public List<Book> getAllBooks() {
		return Arrays.asList(new Book(1283, "Mastering Bitcoin", "Andreas Antonopoulos"));
	}

}
