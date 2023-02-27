package com.cg.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.exception.ResourceNotFoundException;
import com.cg.model.Book;
import com.cg.repository.BookRepository;
@Service
public class BookServiceImpl implements BookService{

	@Autowired
	private BookRepository bookRepository;
	@Override
	public Book saveBook(Book book) {
		return bookRepository.save(book);
	}
	@Override
	public Book getBookById(long bookId) {
Optional<Book>  optionalBook = bookRepository.findById(bookId);
		
		
		
		return optionalBook.get();

	}

	@Override
	public List<Book> getAllBooks() {
		return bookRepository.findAll();
	}

	@Override
	public Book updateBook(Book book) {

		Optional<Book> optionalBook =  bookRepository.findById(book.getBookId());
		
		if(optionalBook.isEmpty()) {
			throw new ResourceNotFoundException("Book Details Not found with id: "+book.getBookId());
		}
		
		Book updatedBook = bookRepository.save(book);
		
		return updatedBook;
	}

	@Override
	public void deleteBook(long bookId) {
		Optional<Book>  optionalBook = bookRepository.findById(bookId);
		
		if(optionalBook.isEmpty()) {
			throw new ResourceNotFoundException("Book not existing with id: "+bookId);
		}
		
		bookRepository.deleteById(bookId);
		
		
	}
	
	@Override
    public List<Book> getAllBookByAuthorName() {
        return bookRepository.findAll().stream().sorted(Comparator.comparing(Book::getAuthorName)).collect(Collectors.toList());
                             
    }
	
	 @Override
	    public void sortBooksByPrice(List<Book> books) {
		 List<Book> sortedBooks = books.stream()
	                .sorted(Comparator.comparing(Book::getPrice))
	                .toList();
	    }
	
	 

}
