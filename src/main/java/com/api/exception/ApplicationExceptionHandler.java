package com.api.exception;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApplicationExceptionHandler {

	@ExceptionHandler(Exception.class)
	public Map<String, String> handleInvalidArgument(MethodArgumentNotValidException ex) {
		Map<String, String> errorMap = new HashMap<>();
		ex.getBindingResult().getFieldErrors().forEach(error -> {
			errorMap.put(error.getField(), error.getDefaultMessage());
		});
		return errorMap;
	}

	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> handler(MethodArgumentNotValidException ex) {
		Map<String, String> map = new HashMap<>();
		List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();
		for (FieldError field : fieldErrors) {
			map.put(field.getField(), field.getDefaultMessage());
		}
		return new ResponseEntity<Map<String, String>>(map, HttpStatus.BAD_REQUEST);
	}

}
