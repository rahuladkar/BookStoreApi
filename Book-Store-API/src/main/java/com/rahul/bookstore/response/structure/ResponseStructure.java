package com.rahul.bookstore.response.structure;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseStructure<T> {

	private int statusCode;
	private String message;
	private T data;

}
