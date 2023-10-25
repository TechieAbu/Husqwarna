package com.husqvarna.todo.exceptions;

public class GenericException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3022981179729590445L;
	
	
	
	private String errorCode;
	private String message;
	
	
	
	
	public GenericException(String errorCode, String message) {
		super();
		this.errorCode = errorCode;
		this.message = message;
	}
	
	
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	

}
