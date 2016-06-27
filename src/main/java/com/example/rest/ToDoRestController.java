package com.example.rest;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.repo.ToDoRepository;
import com.example.domain.ToDo;

@RestController
@RequestMapping("/todo")
public class ToDoRestController {
	
	@Autowired
	ToDoRepository repo;
	
	@RequestMapping(method=RequestMethod.GET, produces={ MediaType.APPLICATION_JSON_VALUE})
	public Iterable<ToDo>getTodos()
	{
		return repo.findAll();
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public Iterable<ToDo> saveTodo(@RequestBody ArrayList<ToDo> todos)
	{
		return repo.save(todos);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/{id}")
	public void deleteToDo(@PathVariable Long id)
	{
		repo.delete(id);
	}

}
