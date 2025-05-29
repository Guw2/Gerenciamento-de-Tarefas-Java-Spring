package com.lorian.userAuthenticationApp.task;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TaskService {

	private final TaskRepository repo;
		
	public TaskService(TaskRepository repo) {
		this.repo = repo;
	}

	public List<TaskDTO> findAllTasks() {
		return repo.findAll().stream().map(x -> TaskMapper.taskToDto(x)).toList();
	}
	
	public TaskDTO findTaskById(Long id) {
		Task t = repo.findById(id)
				.orElseThrow(() -> new RuntimeException("Task Not Found."));
		return TaskMapper.taskToDto(t);
	}
	
	public TaskDTO createTask(Task t) {
		return TaskMapper.taskToDto(repo.save(t));
	}
	
	public TaskDTO updateTask(Long id, Task t) {
		Task task = new Task(
				id,
				t.getTitle(),
				t.getDescription(),
				t.getStatus()
				);
		
		return TaskMapper.taskToDto(repo.save(task));
	}
	
	public void deleteTaskById(Long id) {
		repo.deleteById(id);
	}
	
}
