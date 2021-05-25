package com.examly.springapp;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LibraryManagementController {
	
	BookRepository bookRepository;

	public LibraryManagementController(BookRepository bookRepository) {
		this.bookRepository=bookRepository;
	}
	
	public static <E> List<E> makeCollection(Iterable<E> iter) {
		List<E> list = new ArrayList<E>();
	    for (E item : iter) {
	        list.add(item);
	    }
	    return list;
	}
	
	@RequestMapping("/")
	public String index() {
		return "LibraryManagement by Chintzzie!";
	}
	
	@PostMapping("/saveBook")
	public BookModel addBook(@RequestParam String bookName,@RequestParam String genre,@RequestParam int quantity,@RequestParam int bookId) {
		
		BookModel newBook = new BookModel(bookId, quantity, bookName, genre);
		this.bookRepository.save(newBook);
		
		return this.bookRepository.findById(bookId).get();
		
	}
	
	@PostMapping("/editBook")
	public BookModel updateBook(@RequestParam String bookName,@RequestParam String genre,@RequestParam int quantity,@RequestParam int bookId) {
		
		BookModel newBook = new BookModel(bookId, quantity, bookName, genre);
		this.bookRepository.save(newBook);
		
		return this.bookRepository.findById(bookId).get();
		
	}
	
	@DeleteMapping("/deleteBook")
	public String deleteBook(@RequestParam int bookId) {
		
		this.bookRepository.deleteById(bookId);
		
		return "Deleted Successfully book with id:"+bookId;
		
	}
	
	@GetMapping("/getBooks")
	public List<BookModel> getBooks() {
		
		return makeCollection(this.bookRepository.findAll());
		
	}
	
	@GetMapping("/getByType")
	public List<BookModel> getBooksByType(@RequestParam(value="id") String genre) {
		
		return makeCollection(this.bookRepository.findByGenre(genre));
		
	}
	
	
	
	
	
	
}
