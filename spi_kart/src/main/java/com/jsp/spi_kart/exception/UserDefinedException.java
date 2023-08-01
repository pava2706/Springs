package com.jsp.spi_kart.exception;

@SuppressWarnings("serial")
public class UserDefinedException extends RuntimeException {

	private String message;

	public UserDefinedException(String message) {
		this.message = message;
	}

	@Override
	public String getMessage() {
		return message;
	}
}
