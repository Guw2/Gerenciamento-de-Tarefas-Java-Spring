package com.lorian.taskManagementApp.exception.task_related;

public class TaskIdNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public TaskIdNotFoundException(String msg) {
		super(msg);
	}

}
