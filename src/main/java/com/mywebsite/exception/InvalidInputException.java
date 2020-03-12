/** Copyright Graytrium Technologies. All Rights Reserved**/
package com.mywebsite.exception;

public class InvalidInputException extends Exception {

	
	private static final long serialVersionUID = 1L;
	
	public InvalidInputException() {
		super("Invalid Input");
	}
	
	public InvalidInputException(String message) {
		super(message);
	}
}
