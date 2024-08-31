package com.rahul.bookstore.exception;

public class BookNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private String meassage;

	public BookNotFoundException(String meassge) {
		this.meassage = meassge;
	}

	public String getMeassage() {
		return meassage;
	}

}
