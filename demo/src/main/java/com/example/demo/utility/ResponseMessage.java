package com.example.demo.utility;

public class ResponseMessage {
	private String messsage;
	private int statusCode;
	
	public ResponseMessage(String message, int statusCode) {
		this.statusCode = statusCode;
		this.messsage = message;
	}
	
	public String getMesssage() {
		return messsage;
	}
	public void setMesssage(String messsage) {
		this.messsage = messsage;
	}
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	
	
	
	
	

}
