package com.example.library.app.exception;

public class LibraryRequestException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public LibraryRequestException(String message, Throwable cause) {
		super(message, cause);
	}

	public LibraryRequestException(String message) {
		super(message);
	}

}
