package com.assignment.reverse.exception;

import java.util.Date;

import javax.validation.ConstraintViolationException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
	
	private static final Logger customlogger = LogManager.getLogger(CustomizedResponseEntityExceptionHandler.class);
	
	String errorMessage="An exception occured, which will cause a {} response";
	
	@ExceptionHandler({ ConstraintViolationException.class })
	protected ResponseEntity<Object> handleConstraintViolation(
	  ConstraintViolationException ex, WebRequest request) {
		
		ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(),
    	        request.getDescription(false));		
		customlogger.warn(errorMessage, HttpStatus.BAD_REQUEST);
		return new ResponseEntity(errorDetails, HttpStatus.BAD_REQUEST);
	
	}
	
	@Override
	protected ResponseEntity<Object> handleNoHandlerFoundException(NoHandlerFoundException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request
	  ) {
		
		ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(),
    	        request.getDescription(false));		
		customlogger.warn(errorMessage, HttpStatus.NOT_FOUND);
		return handleExceptionInternal(ex, errorDetails, headers, HttpStatus.NOT_FOUND, request);
	}
	
	
	@ExceptionHandler(Exception.class)
	  public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
		
	    ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(),
    	        request.getDescription(false));
	   
	    customlogger.error(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
	    return new ResponseEntity(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	  }

}
