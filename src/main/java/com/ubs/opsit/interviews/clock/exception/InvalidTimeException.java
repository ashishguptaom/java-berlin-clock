package com.ubs.opsit.interviews.clock.exception;

public class InvalidTimeException extends RuntimeException {
	
	public InvalidTimeException(String errorMessage) {
		super(errorMessage);
	}
}
