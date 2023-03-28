package com.example.library.app.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class LibraryExceptionHandler {
	
	@ExceptionHandler(value= {LibraryRequestException.class})
	public ResponseEntity<Object> handleLibraryRequestException(LibraryRequestException e){
		
		HttpStatus badRequest=HttpStatus.BAD_REQUEST;
	    LibraryException apiException=new LibraryException(e.getMessage());
		return new ResponseEntity<Object>(apiException,badRequest);
	}
}
