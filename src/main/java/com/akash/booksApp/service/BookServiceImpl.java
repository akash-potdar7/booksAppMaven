package com.akash.booksApp.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.akash.booksApp.entity.BookEntity;
import com.akash.booksApp.model.Book;
import com.akash.booksApp.repo.BookRepository;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository bookRepository;

	@Override
	public Book saveBook(Book book) {
		System.out.println("in BookServiceImpl.saveBook()");
		BookEntity entity = new BookEntity();
		entity = viewToEntity(book, entity);
		Book respObj = entityToView(bookRepository.save(entity));
		return respObj;
	}

	// Converts Entity Obj to View Obj
	private Book entityToView(BookEntity entity) {
		Book book = new Book();
		book.setIsbn(entity.getIsbn());
		book.setName(entity.getName());
		book.setGenre(entity.getGenre());
		book.setAuthor(entity.getAuthor());
		return book;
	}

	// Converts View Obj to Entity Obj
	private BookEntity viewToEntity(Book book, BookEntity entity) {
		entity.setIsbn(book.getIsbn());
		entity.setName(book.getName());
		entity.setGenre(book.getGenre());
		entity.setAuthor(book.getAuthor());
		return entity;
	}

	@Override
	public List<Book> getAllBooks() {
		List<Book> books = new ArrayList<Book>();
		Iterator<BookEntity> iterator = bookRepository.findAll().iterator();
		while (iterator.hasNext()) {
			books.add(entityToView(iterator.next()));
		}
		return books;
	}

}
