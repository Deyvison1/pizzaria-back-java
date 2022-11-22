package com.pizzaria.api.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class NotFoundControllerAdvice {

	@ResponseBody
	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<MessageExceptionHandler> registerNotFound(NotFoundException notFoundException) {
		MessageExceptionHandler error = new MessageExceptionHandler(LocalDateTime.now(), HttpStatus.NOT_FOUND.value(), "Nenhum registro encontrado!");
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
}
