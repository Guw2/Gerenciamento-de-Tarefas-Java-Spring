package com.lorian.userAuthenticationApp.exception;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.lorian.userAuthenticationApp.exception.task_related.TaskIdNotFoundException;

@ControllerAdvice
public class CustomResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(value = TaskIdNotFoundException.class)
	public ResponseEntity<ExceptionTemplate> taskIdNotFoundExceptionHandler
	(TaskIdNotFoundException e, WebRequest req){
		ExceptionTemplate template = new ExceptionTemplate(
				getInstant(), "404",
				"NOT FOUND", e.getMessage(), req.getDescription(false)
				);
		return new ResponseEntity<ExceptionTemplate>(template, HttpStatus.NOT_FOUND);
	}
	
	private final Instant getInstant() {
		return LocalDateTime.now().toInstant(ZoneOffset.ofHours(-3));
	}

}
