package com.lorian.taskManagementApp.task;

import org.springframework.stereotype.Component;

@Component
public class TaskMapper {
	
	protected static TaskDTO taskToDto(Task t) {
		TaskDTO dto = new TaskDTO(
				t.getTitle(),
				t.getDescription(),
				t.getStatus());
		
		return dto;
	}
	
	protected static Task dtoToTask(TaskDTO dto) {
		Task t = new Task();
		
		t.setTitle(dto.title());
		t.setDescription(dto.description());
		t.setStatus(dto.status());
		
		return t;
	}

}
