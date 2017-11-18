package com.akash.booksApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.akash.booksApp.model.Book;
import com.akash.booksApp.model.Genre;
import com.akash.booksApp.service.BookService;

@RestController
@RequestMapping("/api")
public class BookController {

	@Autowired
	BookService bookService;

	public BookController() {
	}

	// To test RequestMapping
	@RequestMapping("/")
	public String getHello() {
		return "Working..!";
	}

	@RequestMapping(value = "/allBooks", method = RequestMethod.GET)
	public List<Book> getAllBooks() {
		return bookService.getAllBooks();
	}

	@RequestMapping(value = "/saveBook", method = RequestMethod.POST)
	public Book saveBook(@RequestBody Book book) {
		return bookService.saveBook(book);
	}

	@RequestMapping(value = "/getGenreData", method = RequestMethod.GET)
	public List<Genre> getGenreDropDownData() {
		return bookService.getGenreData();
	}

	@RequestMapping(value = "/updateBook", method = RequestMethod.POST)
	public Book updateBook(@RequestBody Book book) {
		return bookService.updateBook(book);
	}
	
	@RequestMapping(value = "/deleteBook", method = RequestMethod.POST)
	public void deleteBook(@RequestBody Book book) {
		bookService.deleteBook(book.getIsbn());
	}
}
