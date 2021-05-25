package com.examly.springapp;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface LogRepository extends CrudRepository<LogModel, String>{
	public List<LogModel> findByDate(String date);
}
