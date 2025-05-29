package com.lorian.userAuthenticationApp.task;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

@Service
public class TaskService {

	private final TaskRepository repo;
	
	public TaskService(TaskRepository repo) {
		this.repo = repo;
	}

	public List<Task> findAllTasks() {
		return repo.findAll();
	}
	
	public Task findTaskById(UUID id) {
		return repo.findById(id)
				.orElseThrow(() -> new RuntimeException("Task Not Found."));
	}
	
	public Task createTask(Task t) {
		return repo.save(t);
	}
	
	public Task updateTask(UUID id, Task t) {
		Task task = new Task(
				id,
				t.getTitle(),
				t.getDescription(),
				t.getStatus(),
				t.getCreationDate()
				);
		
		return repo.save(task);
	}
	
	public void deleteTaskById(UUID id) {
		repo.deleteById(id);
	}
	
}
