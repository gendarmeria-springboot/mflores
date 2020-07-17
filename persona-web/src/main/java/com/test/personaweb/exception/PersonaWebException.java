package com.test.personaweb.exception;

import org.springframework.http.HttpStatus;

public class PersonaWebException extends Exception{
	private static final long serialVersionUID = 1L;

	private HttpStatus MyError;

	public HttpStatus getMyError() {
		return MyError;
	}
	
	public PersonaWebException(String message, HttpStatus myError) {
		super(message);
		this.MyError = myError;
	}
}

