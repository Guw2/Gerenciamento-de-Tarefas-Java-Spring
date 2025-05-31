package com.lorian.taskManagementApp.task;

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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/task")
@Tag(name = "Tasks", description = "Task Management Endpoints")
public class TaskController {

	private final TaskService service;

	public TaskController(TaskService service) {
		this.service = service;
	}
		
	@GetMapping
	@Operation(summary = "Search For All Tasks", 
	description = "It can be filtered by 'status' if specified. ex.: (.../task?status=PENDING).")
	@ApiResponse(responseCode = "200")
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
	@Operation(summary = "Search For a Specific Task By ID.")
	@ApiResponse(responseCode = "200")
	public ResponseEntity<TaskDTO> findById(@PathVariable Long id){
		return new ResponseEntity<TaskDTO>(service.findTaskById(id), HttpStatus.OK);
	}
	
	@PostMapping
	@Operation(summary = "Create a New Task In The Database", 
	description = "A task must be sent using POST. It will be validated and, if it's valid, stored.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = "Task Created Successfully."),
			@ApiResponse(responseCode = "400", description = "Task Is Not Valid.")
	})
	public ResponseEntity<TaskDTO> create(@RequestBody @Valid TaskDTO dto){
		return new ResponseEntity<TaskDTO>(service.createTask(dto), HttpStatus.CREATED);
	}
	
	@PostMapping("/{id}")
	@Operation(summary = "Update An Existing Task.",
	description = "A task must be sent using POST along with the ID of the original one. It will be validated and, if it's valid, stored.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "202", description = "Task Edited Successfully."),
			@ApiResponse(responseCode = "400", description = "Task Is Not Valid.")
	})
	public ResponseEntity<TaskDTO> update(@RequestBody @Valid TaskDTO dto, @PathVariable Long id){
		return new ResponseEntity<TaskDTO>(service.updateTask(id, dto), HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/{id}")
	@Operation(summary = "Delete A Task By ID")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "204", description = "Task Deleted Successfully."),
			@ApiResponse(responseCode = "404", description = "Task Not Found.")
	})
	public ResponseEntity<?> delete(@PathVariable Long id){
		service.deleteTaskById(id);
		return ResponseEntity.noContent().build();
	}
	
}
