package com.pizzaria.api.exceptions;

import java.time.LocalDateTime;

public class MessageExceptionHandler {

	private LocalDateTime date;
	private Integer status;
	private String message;
	
	public MessageExceptionHandler(LocalDateTime date, Integer status, String message) {
		this.date = date;
		this.status= status;
		this.message = message;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
