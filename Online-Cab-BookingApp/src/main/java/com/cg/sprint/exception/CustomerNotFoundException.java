package com.cg.sprint.exception;

public class CustomerNotFoundException extends RuntimeException{

	public CustomerNotFoundException(String message) {
		super(message);
	}
	public CustomerNotFoundException() {
		super();
	}

}
