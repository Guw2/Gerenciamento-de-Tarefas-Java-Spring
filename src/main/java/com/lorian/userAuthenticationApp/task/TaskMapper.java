package com.lorian.userAuthenticationApp.task;

import org.springframework.stereotype.Component;

@Component
public class TaskMapper {
	
	protected static TaskDTO taskToDto(Task t) {
		TaskDTO dto = new TaskDTO(t.getId(),
				t.getTitle(),
				t.getDescription(),
				t.getStatus());
		
		return dto;
	}

}
