package com.cts.claim.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> handleGlobalException(Exception ex, WebRequest request) {
		ErrorResponse response = new ErrorResponse();
		response.setStatusCode(404);
		response.setStatusDate(LocalDateTime.now());
		response.setStatusMsg(ex.getMessage());
		log.error(ex.getMessage());
		return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
	}
	
}