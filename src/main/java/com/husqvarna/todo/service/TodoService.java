package com.husqvarna.todo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.husqvarna.todo.TodoRequest;
import com.husqvarna.todo.business.model.ToDoEntity;
import com.husqvarna.todo.enums.StatusEnum;
import com.husqvarna.todo.exceptions.GenericException;
import com.husqvarna.todo.repository.ToDoRepository;

@Service
public class TodoService {

	@Autowired
	private ToDoRepository repository;
	
	public ToDoEntity createOrUpdateToDoRecord(TodoRequest request) {
		
		Optional<ToDoEntity> toDoRecord = Optional.empty();
		
		if (null != request.getId()) {
			toDoRecord = repository.findById(request.getId());
		}
		
		if(toDoRecord.isPresent()){
			
			ToDoEntity existingToDo = toDoRecord.get();
			existingToDo.setId(request.getId());
			existingToDo.setStatus(request.getStatus());
			existingToDo.setDescription(request.getDescription());
			
			return repository.save(existingToDo);
			
			
			
		} else {
			
			ToDoEntity entity = new  ToDoEntity();
			entity.setStatus(request.getStatus());
			entity.setDescription(request.getDescription());
			repository.save(entity);
			return entity;
		}
	}
	
	
	public StatusEnum deleteToDoRecord(int id) {
		Optional<ToDoEntity> toDoRecord = repository.findById(id);
		
		if (toDoRecord.isPresent()) {
			repository.deleteById(id);
			return StatusEnum.S300;
		} else {
			throw new GenericException(StatusEnum.E100.getCode(), StatusEnum.E100.getMessage());
		}
		
	}
	
	
	public List<ToDoEntity> listTodoRecords(Integer id) {
		
		List<ToDoEntity> list = new ArrayList<ToDoEntity>();
		
		if (null == id) {
			 list.addAll(repository.findAll());
			
		} else {
			Optional<ToDoEntity> toDoRecord = repository.findById(id);
			
			if (toDoRecord.isPresent()) {
				list.add(toDoRecord.get());
			} else {
				throw new GenericException(StatusEnum.E100.getCode(), StatusEnum.E100.getMessage());

			}
		}
		
		return list;
		
	}
}
