package com.credmarg.vendor.exception;

//Custom checked exception extending Exception
public class InvalidLengthException extends Exception {

	// Default constructor
	public InvalidLengthException() {
		super("Invalid Length");
	}
	
	// Constructor that accepts a custom error message
	public InvalidLengthException(String msg) {
		super(msg);
	}
}
