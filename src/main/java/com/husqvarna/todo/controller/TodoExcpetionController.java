package com.husqvarna.todo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.husqvarna.todo.enums.StatusEnum;
import com.husqvarna.todo.exceptions.GenericException;

@ControllerAdvice
public class TodoExcpetionController {
	
	
	@ExceptionHandler(value = GenericException.class)
	public ResponseEntity<StatusEnum> HandleGeneRicException(GenericException ex) {
		return new ResponseEntity<StatusEnum>(StatusEnum.valueOf(ex.getErrorCode()),HttpStatus.NOT_FOUND);		
	}

}
