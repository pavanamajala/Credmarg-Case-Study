package com.credmarg.vendor.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(InvalidLengthException.class)
	public ResponseEntity<ApiErrorResponse> handleInvalidLengthException(Exception e, WebRequest request) {
		System.out.println(e +"  "+ request);
		ApiErrorResponse errorResponse = new ApiErrorResponse(HttpStatus.BAD_REQUEST.value(), e.getMessage());
		return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<ApiErrorResponse> handleHttpMessageNotReadableException(HttpMessageNotReadableException ex,
			WebRequest request) {
		ApiErrorResponse errorResponse = new ApiErrorResponse(HttpStatus.BAD_REQUEST.value(),
				"Invalid input provided: " + ex.getMessage());

		return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<ApiErrorResponse> handleIllegalArgumentException(IllegalArgumentException ie, WebRequest request){
		ApiErrorResponse errorResponse = new ApiErrorResponse(HttpStatus.BAD_REQUEST.value(), ie.getMessage());
		return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ApiErrorResponse> handleExceptios(Exception e, WebRequest request) {
		System.out.println(request);
		ApiErrorResponse errorResponse = new ApiErrorResponse(HttpStatus.BAD_REQUEST.value(), e.getMessage());
		return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
	}

}
