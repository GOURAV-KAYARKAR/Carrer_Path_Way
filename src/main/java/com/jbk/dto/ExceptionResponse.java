package com.jbk.dto;

import java.sql.Timestamp;

public class ExceptionResponse {

	
	private String message;
	private String  path;
	private Timestamp timestamp;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public Timestamp getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}
	@Override
	public String toString() {
		return "ExceptionResponse [message=" + message + ", path=" + path + ", timestamp=" + timestamp + "]";
	}
	public ExceptionResponse(String message, String path, Timestamp timestamp) {
		super();
		this.message = message;
		this.path = path;
		this.timestamp = timestamp;
	}
	public ExceptionResponse() {
		super();
	}
	
}