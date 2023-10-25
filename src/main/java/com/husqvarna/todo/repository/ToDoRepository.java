package com.husqvarna.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.husqvarna.todo.business.model.ToDoEntity;

public interface ToDoRepository extends JpaRepository<ToDoEntity, Integer> {

}
