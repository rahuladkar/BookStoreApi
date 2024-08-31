package com.rahul.bookstore.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.rahul.bookstore.response.structure.ResponseStructure;

@ControllerAdvice
public class GlobalExceptionHandler {

	// To handle the BookNotFoundException
	@ExceptionHandler(BookNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> handleBookNotFoundException(BookNotFoundException exception) {

		ResponseStructure<String> responseStructure = new ResponseStructure<String>();
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("Book Not Found...!");
		responseStructure.setData(exception.getMeassage());

		return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.NOT_FOUND);

	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ResponseStructure<Map<String, String>>> handleMethodArgumentNotValid(
			MethodArgumentNotValidException methodArgumentNotValidException) {
		ResponseStructure<Map<String, String>> responseStructure = new ResponseStructure<>();
		Map<String, String> map = new HashMap<>();

		methodArgumentNotValidException.getBindingResult().getAllErrors().forEach((error) -> {
			String fieldName = ((FieldError) error).getField();
			String errorMessage = error.getDefaultMessage();
			map.put(fieldName, errorMessage);
		});

		responseStructure.setMessage("Data is not valid, please correct it...!");
		responseStructure.setData(map);
		responseStructure.setStatusCode(HttpStatus.BAD_REQUEST.value());

		return new ResponseEntity<>(responseStructure, HttpStatus.BAD_REQUEST);
	}

	// To handle all other exception
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ResponseStructure<String>> handleAllException(Exception exception) {

		ResponseStructure<String> responseStructure = new ResponseStructure<String>();
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("Bad Request , please correct it");
		responseStructure.setData(exception.toString());

		return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.NOT_FOUND);

	}

}
