package com.jrd.akash.booksApp.service;

import java.util.List;

import com.jrd.akash.booksApp.model.Book;

public interface BookService {

	Book saveBook(Book book);

	List<Book> getAllBooks();

}
