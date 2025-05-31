package com.lorian.taskManagementApp.exception;

import java.time.Instant;
import java.util.Objects;

public class ExceptionTemplate {
	
	private final Instant timeStamp;
	private final String status;
	private final String error;
	private final String description;
	private final String path;

	public ExceptionTemplate(Instant timeStamp, String status, String error, String description, String path) {
		this.timeStamp = timeStamp;
		this.status = status;
		this.error = error;
		this.description = description;
		this.path = path;
	}

	public Instant getTimeStamp() {
		return timeStamp;
	}

	public String getStatus() {
		return status;
	}

	public String getError() {
		return error;
	}

	public String getDescription() {
		return description;
	}

	public String getPath() {
		return path;
	}

	@Override
	public String toString() {
		return "ExceptionTemplate [timeStamp=" + timeStamp + ", status=" + status + ", error=" + error
				+ ", description=" + description + ", path=" + path + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(description, error, path, status, timeStamp);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ExceptionTemplate other = (ExceptionTemplate) obj;
		return Objects.equals(description, other.description) && Objects.equals(error, other.error)
				&& Objects.equals(path, other.path) && Objects.equals(status, other.status)
				&& Objects.equals(timeStamp, other.timeStamp);
	}
	
}
