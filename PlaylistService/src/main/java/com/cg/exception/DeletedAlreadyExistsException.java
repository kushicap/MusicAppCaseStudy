package com.cg.exception;
//Extends exception 
public class DeletedAlreadyExistsException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
//parameterized constructor
	public DeletedAlreadyExistsException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DeletedAlreadyExistsException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	

}
