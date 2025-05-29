package com.lorian.userAuthenticationApp.task;

import java.time.LocalDateTime;
import java.util.Objects;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Task {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private String title;
	@Column
	private String description;
	@Column
	private TaskStatus status;
	@Column
	private LocalDateTime creationDate = LocalDateTime.now();
	
	public Task() {
	}

	public Task(Long id, String title, String description, TaskStatus status) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public TaskStatus getStatus() {
		return status;
	}

	public void setStatus(TaskStatus status) {
		this.status = status;
	}

	public LocalDateTime getCreationDate() {
		return creationDate;
	}

	@Override
	public String toString() {
		return "Task [id=" + id + ", title=" + title + ", description=" + description + ", status=" + status
				+ ", creationDate=" + creationDate + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(creationDate, description, id, status, title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Task other = (Task) obj;
		return Objects.equals(creationDate, other.creationDate) && Objects.equals(description, other.description)
				&& Objects.equals(id, other.id) && status == other.status && Objects.equals(title, other.title);
	}
	
	
}
