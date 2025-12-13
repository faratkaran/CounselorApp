package com.ca.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AppExceptionHandler {

	// design a method to handle all exceptions.

	@ExceptionHandler(CounselorNotFound.class)
	public ResponseEntity<?> catchCounselorNotFound() {
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}
