package com.examly.springapp;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.collections4.IteratorUtils;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerLogController {
	
	LogRepository logRepository;

	public CustomerLogController(LogRepository logRepository) {
		this.logRepository = logRepository;
	}
	
	public static <E> List<E> makeCollection(Iterable<E> iter) {
		List<E> list = new ArrayList<E>();
	    for (E item : iter) {
	        list.add(item);
	    }
	    return list;
	}
	
	public LogModel checkOff(String logType,String name) {
		String time,date,id;
		time=LocalTime.now().toString();
		date=DateTimeFormatter.ofPattern("YYYY/MM/dd").format(LocalDate.now());
		
		id=name+time;
		
		LogModel log=new LogModel(id,name,date,time,logType);
		logRepository.save(log);
		
		return logRepository.findById(id).get();
		
	}

	@RequestMapping("/")
	public String index() {
		return "customerLog by Chintzzie!";
	}
	
	
	@GetMapping("/getAllLog")
	public List<LogModel> getAllLog() {
		
		return this.makeCollection(this.logRepository.findAll() );
	}
	
	@GetMapping("/checkin")
	public LogModel checkIn(@RequestParam String name) {
		
		return this.checkOff("IN", name);
		
	}
	
	
	
	@GetMapping("/checkOut")
	public LogModel checkOut(@RequestParam String name) {
		return this.checkOff("OUT", name);
		
		
	}
	
	@GetMapping("/getLog")
	public List<LogModel> getLog(@RequestParam String date) {
		
		return this.makeCollection(this.logRepository.findByDate(date) );
	}
	
	
}
