package com.example.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.Type;

@Entity
public class ToDo {

	@Id
	@SequenceGenerator(name="TODO_ID_GENERATOR", sequenceName="TODO_ID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TODO_ID_GENERATOR")
	long id;
	
	String name;
	
	@Type(type="yes_no")
	boolean completed;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isCompleted() {
		return completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}
	
	
}
