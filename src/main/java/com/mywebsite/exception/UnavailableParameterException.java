/** Copyright Graytrium Technologies. All Rights Reserved**/
package com.mywebsite.exception;

public class UnavailableParameterException extends Exception {

	
	private static final long serialVersionUID = 1L;
	
	public UnavailableParameterException() {
		super("Parameter not Found");
	}
	
	public UnavailableParameterException(String message) {
		super(message);
	}
}
