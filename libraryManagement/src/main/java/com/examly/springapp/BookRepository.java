package com.examly.springapp;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<BookModel, Integer>{
	public List<BookModel> findByGenre(String genre);
}
