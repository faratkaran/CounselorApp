package com.ca.exception;

public class CounselorNotFound extends RuntimeException {
	
	private String message;

	public CounselorNotFound() {
	}

	public CounselorNotFound(String message) {
		this.message = message;
	}

	@Override
	public String getMessage() {
		return this.message;
	}
}