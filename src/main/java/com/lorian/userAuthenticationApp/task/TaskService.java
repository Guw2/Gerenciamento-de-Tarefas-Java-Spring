package com.lorian.userAuthenticationApp.task;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

	private final TaskRepository repo;
		
	public TaskService(TaskRepository repo) {
		this.repo = repo;
	}

	public Page<TaskDTO> findAllTasks(Pageable pageable) {
		return repo.findAll(pageable).map(x -> TaskMapper.taskToDto(x));
	}
	
	public Page<TaskDTO> findTaskByStatus(TaskStatus status, Pageable pageable){
		return repo.findByStatus(status, pageable).map(x -> TaskMapper.taskToDto(x));
	}
	
	public TaskDTO findTaskById(Long id) {
		Task t = repo.findById(id)
				.orElseThrow(() -> new RuntimeException("Task Not Found."));
		return TaskMapper.taskToDto(t);
	}
	
	public TaskDTO createTask(TaskDTO dto) {
		Task task = TaskMapper.dtoToTask(dto);
		return TaskMapper.taskToDto(repo.save(task));
	}
	
	public TaskDTO updateTask(Long id, TaskDTO dto) {
		Task task = TaskMapper.dtoToTask(dto);
		task.setId(id);
		return TaskMapper.taskToDto(repo.save(task));
	}
	
	public void deleteTaskById(Long id) {
		repo.deleteById(id);
	}
	
}
