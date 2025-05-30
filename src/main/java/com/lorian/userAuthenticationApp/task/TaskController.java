package com.lorian.userAuthenticationApp.task;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/task")
public class TaskController {

	private final TaskService service;

	public TaskController(TaskService service) {
		this.service = service;
	}
		
	@GetMapping
	public ResponseEntity<Page<TaskDTO>> findAll(
			@RequestParam(required = false) TaskStatus status,
			Pageable pageable){
		if(status == null) {
			return new ResponseEntity<Page<TaskDTO>>(service.findAllTasks(pageable), HttpStatus.OK);
		}else {
			return new ResponseEntity<Page<TaskDTO>>(service.findTaskByStatus(status, pageable), HttpStatus.OK);
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<TaskDTO> findById(@PathVariable Long id){
		return new ResponseEntity<TaskDTO>(service.findTaskById(id), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<TaskDTO> create(@RequestBody @Valid TaskDTO dto){
		return new ResponseEntity<TaskDTO>(service.createTask(dto), HttpStatus.CREATED);
	}
	
	@PostMapping("/{id}")
	public ResponseEntity<TaskDTO> update(@RequestBody @Valid TaskDTO dto, @PathVariable Long id){
		return new ResponseEntity<TaskDTO>(service.updateTask(id, dto), HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		return ResponseEntity.noContent().build();
	}
	
}
