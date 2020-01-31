package com.user.credit.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Custom exception class
 * 
 * @author Hariom
 *
 */
@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "NotFoundException not found")
public class NotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	/**
	 * Method to print custome message
	 * 
	 * @param message
	 */
	public NotFoundException(String message) {
		super(message);
	}

	/**
	 * Method to create custom message with exception throw.
	 * 
	 * @param message
	 * @param cause
	 */
	public NotFoundException(String message, Throwable cause) {
		super(message, cause);
	}
}