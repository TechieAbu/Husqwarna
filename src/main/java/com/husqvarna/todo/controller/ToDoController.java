package com.husqvarna.todo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.husqvarna.todo.TodoRequest;
import com.husqvarna.todo.business.model.ToDoEntity;
import com.husqvarna.todo.enums.StatusEnum;
import com.husqvarna.todo.exceptions.GenericException;
import com.husqvarna.todo.repository.ToDoRepository;
import com.husqvarna.todo.service.TodoService;

@RestController
@RequestMapping("/todo")

public class ToDoController {

	@Autowired
	private TodoService service;
	
	@RequestMapping(value = "/createOrUpdate", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public ResponseEntity<ToDoEntity> addOrUpdateTodoRecord (@RequestBody TodoRequest request) throws GenericException{
		
		try {
			
		 ToDoEntity entity = service.createOrUpdateToDoRecord(request);	
		 return new ResponseEntity<ToDoEntity>(entity, HttpStatus.OK);
			
			
		}catch(Exception e) {			
			throw e;
		}
		
		
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = "application/json")
	public ResponseEntity<StatusEnum> deleteTodoRecord(@PathVariable Integer id ) {
		try {
			
			StatusEnum status = service.deleteToDoRecord(id.intValue());
			return new ResponseEntity<StatusEnum>(status, HttpStatus.OK);
			
		}catch (Exception e) {
			throw e;
		}
		
	}
	
	@GetMapping(value = "/get/{id}", produces = "application/json")
	public ResponseEntity<List<ToDoEntity>> listTodoRecords(@PathVariable Integer id ) {
		
		try {
				
		    return new ResponseEntity<List<ToDoEntity>>(service.listTodoRecords(id.intValue())	
			, HttpStatus.OK);
		}catch (Exception e) {
			throw e;
		}
		
		
	}
}
