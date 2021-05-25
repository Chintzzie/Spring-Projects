package com.examly.springapp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class LogModel {
	
	@Id
	private String id;
	private String name;
	private String date;
	private String time;
	private String logType;
	
	public LogModel() {
		
	}
	

	



	public String getLogType() {
		return logType;
	}






	public void setLogType(String logType) {
		this.logType = logType;
	}






	public LogModel(String id, String name, String date, String time, String logType) {
		super();
		this.id = id;
		this.name = name;
		this.date = date;
		this.time = time;
		this.logType = logType;
	}






	@Override
	public String toString() {
		return "LogModel [id=" + id + ", name=" + name + ", date=" + date + ", time=" + time + ", logType=" + logType
				+ "]";
	}






	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
	

}
