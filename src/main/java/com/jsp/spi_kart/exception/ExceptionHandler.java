package com.jsp.spi_kart.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.jsp.spi_kart.helper.ResponseStructure;

public class ExceptionHandler {

	public ResponseEntity<ResponseStructure<String>> handlingException(UserDefinedException ue) {
		ResponseStructure<String> responseStructure = new ResponseStructure<>();
		responseStructure.setMessage(" ");
		responseStructure.setStatus(HttpStatus.BAD_REQUEST.value());
		responseStructure.setData(ue.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure, null, HttpStatus.BAD_REQUEST.value());
	}
}
