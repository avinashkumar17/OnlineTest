package com.example.demo.utility;

import org.springframework.http.HttpStatus;

public class CustomException extends Exception {
	private HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
	public CustomException(String message,HttpStatus httpStatus) {
		super(message);
		this.httpStatus=httpStatus;
	}
	public HttpStatus getHttpStatus() {
		return httpStatus;
	}
	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}
	

}
