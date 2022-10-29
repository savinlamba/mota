	package com.cg.sprint.validation;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cg.sprint.exception.AdminNotFoundException;
import com.cg.sprint.exception.CabNotFoundException;
import com.cg.sprint.exception.CustomerNotFoundException;

@RestControllerAdvice
public class ValidationHandler {

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String,String> invalidArguments(MethodArgumentNotValidException ex)
	{
		Map<String,String> errors=new HashMap<>();
		 ex.getBindingResult().getFieldErrors().forEach(error->{
			errors.put(error.getField(),error.getDefaultMessage());
			});
		return errors;
	}
	
	@ExceptionHandler(AdminNotFoundException.class)
	public ResponseEntity<String> handleAdminNotFound(AdminNotFoundException e) {
		return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(CabNotFoundException.class)
	public ResponseEntity<String> handleCabNotFound(CabNotFoundException e) {
		return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(CustomerNotFoundException.class)
	public ResponseEntity<String> handleCustomerNotFound(CustomerNotFoundException e) {
		return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
	}
}
