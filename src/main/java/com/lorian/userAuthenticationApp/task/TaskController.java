package com.lorian.userAuthenticationApp.task;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/task")
public class TaskController {

	private final TaskService service;

	public TaskController(TaskService service) {
		this.service = service;
	}
		
	@GetMapping
	public ResponseEntity<List<Task>> findAll(){
		return new ResponseEntity<List<Task>>(service.findAllTasks(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Task> findById(@PathVariable Long id){
		return new ResponseEntity<Task>(service.findTaskById(id), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Task> create(@RequestBody Task t){
		return new ResponseEntity<Task>(service.createTask(t), HttpStatus.CREATED);
	}
	
	@PostMapping("/{id}")
	public ResponseEntity<Task> update(@RequestBody Task t, @PathVariable Long id){
		return new ResponseEntity<Task>(service.updateTask(id, t), HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		return ResponseEntity.noContent().build();
	}
	
}
