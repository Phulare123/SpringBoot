package com.cg.service;

import java.util.List;

import com.cg.model.Book;

public interface BookService {

	Book saveBook(Book book);

	Book getBookById(long bookId);

	List<Book> getAllBooks();

	public Book updateBook(Book book);

	public void deleteBook(long bookId);

	List<Book> getAllBookByAuthorName();
	void sortBooksByPrice(List<Book> books);
	

}
