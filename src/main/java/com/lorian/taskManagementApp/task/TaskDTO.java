package com.lorian.taskManagementApp.task;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record TaskDTO(
		@NotBlank String title,
		@NotBlank String description,
		@NotNull TaskStatus status) {

}
