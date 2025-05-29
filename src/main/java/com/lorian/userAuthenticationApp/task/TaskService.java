package com.lorian.userAuthenticationApp.task;

import java.util.List;

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
	
	public Task findTaskById(Long id) {
		return repo.findById(id)
				.orElseThrow(() -> new RuntimeException("Task Not Found."));
	}
	
	public Task createTask(Task t) {
		return repo.save(t);
	}
	
	public Task updateTask(Long id, Task t) {
		Task task = new Task(
				id,
				t.getTitle(),
				t.getDescription(),
				t.getStatus(),
				t.getCreationDate()
				);
		
		return repo.save(task);
	}
	
	public void deleteTaskById(Long id) {
		repo.deleteById(id);
	}
	
}
