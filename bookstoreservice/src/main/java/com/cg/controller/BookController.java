package com.cg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.model.Book;
import com.cg.service.BookService;

@RestController
	@RequestMapping("/Book")
	public class BookController {
	
	@Autowired
	private BookService bookService;
		
		@PostMapping("/save")
		public ResponseEntity<Book> addBook(@RequestBody Book book) {
			
			Book newBook = bookService.saveBook(book);	
			ResponseEntity<Book> responseEntity = new ResponseEntity<>(newBook,HttpStatus.CREATED);		
			return responseEntity;
		}
		
		@GetMapping("/{bookId}")
		public ResponseEntity<Book> fetchBook(@PathVariable("bookId") long bookId) {
			Book newBook = bookService.getBookById(bookId);
			 ResponseEntity<Book> responseEntity=new ResponseEntity<>(newBook,HttpStatus.OK);
			return responseEntity;
		}
		
		@GetMapping("/all")
		public List<Book> fetchAllBook() {
			
			List<Book> bookList = bookService.getAllBooks();	
			return bookList;
		}
		@DeleteMapping("/delete/{bookId}")
	public ResponseEntity<String> removeBook(@PathVariable("bookId") long bookId) {
			
			bookService.deleteBook(bookId);
			ResponseEntity<String> responseEntity = new ResponseEntity<>("Book deleted successfully",HttpStatus.OK);		
			return responseEntity;
		}
		@PutMapping("/update")
		public ResponseEntity<Book> modifyBus(@RequestBody Book book) {
			
			Book updatedBook= bookService.updateBook(book);	
			ResponseEntity<Book> responseEntity = new ResponseEntity<>(book,HttpStatus.CREATED);
			return responseEntity;
		}
		
		@GetMapping("/getBookByAuthorName")
	    public List<Book> getAllBookByAuthorName() {
	        return bookService.getAllBookByAuthorName();
	    }
		
		
		
		
}

