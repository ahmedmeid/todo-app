package com.example.repo;

import org.springframework.data.repository.CrudRepository;

import com.example.domain.ToDo;

public interface ToDoRepository extends CrudRepository<ToDo, Long>{

}
