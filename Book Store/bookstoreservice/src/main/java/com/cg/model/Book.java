package com.cg.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="book_tbl")
public class Book {

	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private long bookId;
	    
	    @Column(name="BookName")
	    private String bookName;
	    
	    @Column(name="AuthorName")
	    private String authorName;
	    
	    @Column(name="Price")
	    private double price;
	    
	    @Column(name="Publisher")
	    private String publisher;
	    
	    @Column(name="Section")
	    private String section;
	    
	    
	    
	    
		public Book(long bookId, String bookName, String authorName, double price, String publisher, String section) {
			super();
			this.bookId = bookId;
			this.bookName = bookName;
			this.authorName = authorName;
			this.price = price;
			this.publisher = publisher;
			this.section = section;
		}
		
		public Book() {
			super();
			// TODO Auto-generated constructor stub
		}

		public long getBookId() {
			return bookId;
		}
		public void setBookId(int bookId) {
			this.bookId = bookId;
		}
		public String getBookName() {
			return bookName;
		}
		public void setBookName(String bookName) {
			this.bookName = bookName;
		}
		public String getAuthorName() {
			return authorName;
		}
		public void setAuthorName(String authorName) {
			this.authorName = authorName;
		}
		public double getPrice() {
			return price;
		}
		public void setPrice(double price) {
			this.price = price;
		}
		public String getPublisher() {
			return publisher;
		}
		public void setPublisher(String publisher) {
			this.publisher = publisher;
		}
		public String getSection() {
			return section;
		}
		public void setSection(String section) {
			this.section = section;
		}
		@Override
		public String toString() {
			return "Book [bookId=" + bookId + ", bookName=" + bookName + ", authorName=" + authorName + ", price=" + price
					+ ", publisher=" + publisher + ", section=" + section + "]";
		}
	    
		
	    
	    
	    
	    

	   
	    
	    
	    
	  
}
