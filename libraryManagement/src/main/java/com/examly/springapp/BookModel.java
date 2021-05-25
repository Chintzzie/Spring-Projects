package com.examly.springapp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class BookModel {
	
	@Id
	private int bookId;
	private int quantity;
	private String bookName;
	private String genre;
	
	public BookModel() {
		
	}

	@Override
	public String toString() {
		return "BookModel [bookId=" + bookId + ", quantity=" + quantity + ", bookName=" + bookName + ", genre=" + genre
				+ "]";
	}

	

	public BookModel(int bookId, int quantity, String bookName, String genre) {
		super();
		this.bookId = bookId;
		this.quantity = quantity;
		this.bookName = bookName;
		this.genre = genre;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}
	

	

}
