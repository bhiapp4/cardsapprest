package com.cardsapp.exceptions;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice//AOP advice to do the exception handling
public class RestExceptionHandler {

	//all possible exceptions we will write a handle method
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(value=HttpStatus.BAD_REQUEST)//400
	public List<String> handleMethodArgumentNotValidException(MethodArgumentNotValidException ma) {
		List<String>messages = new ArrayList<>();
		List<ObjectError>errors = ma.getBindingResult().getAllErrors();
		errors.forEach(e -> messages.add(e.getDefaultMessage()));
		return messages;
	}
	
	@ExceptionHandler(Exception.class)
	@ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR)//500
	public String handleAllOtherExceptions(Exception e) {
		return e.getMessage();
	}
	
	@ExceptionHandler(NotFoundException.class)
	@ResponseStatus(value=HttpStatus.NOT_FOUND)//404
	public String handleAllOtherExceptions(NotFoundException nfe) {
		return nfe.getMessage();
	}
	
}
