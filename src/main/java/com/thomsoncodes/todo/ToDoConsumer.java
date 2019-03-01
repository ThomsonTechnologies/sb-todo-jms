package com.thomsoncodes.todo;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.thomsoncodes.todo.domain.ToDo;
import com.thomsoncodes.todo.jms.ToDoProducer;
import com.thomsoncodes.todo.repository.ToDoRepository;

@Component
public class ToDoConsumer {
	private static Logger log = LoggerFactory.getLogger(ToDoProducer.class);
	
	private ToDoRepository repository;
	
	public ToDoConsumer(ToDoRepository repository) {
		this.repository = repository;
	}
	
	@JmsListener(destination = "${todo.jms.destination}", containerFactory = "jmsFactory")
	public void processToDo(@Valid ToDo todo) {
		log.info("Consumer> " + todo);
		log.info("ToDo created> " + this.repository.save(todo));
	}
}
