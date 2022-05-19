package com.cg.exception;

public class SongsAlreadyExistsException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
//paramerized Constructor
	public SongsAlreadyExistsException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SongsAlreadyExistsException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	} 

}
