package com.ubs.opsit.interviews.clock.exception;

@SuppressWarnings("serial")
public class InvalidTimeException extends RuntimeException {

	public InvalidTimeException(String errorMessage) {
		super(errorMessage);
	}
}
