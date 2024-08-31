package com.rahul.bookstore.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.rahul.bookstore.dto.BookDTO;
import com.rahul.bookstore.entity.Book;
import com.rahul.bookstore.exception.BookNotFoundException;
import com.rahul.bookstore.repository.BookRepository;
import com.rahul.bookstore.response.structure.ResponseStructure;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepository;
	@Autowired
	private ModelMapper modelMapper;

	// To add new book
	public ResponseEntity<ResponseStructure<Book>> addBook(BookDTO bookDTO) {

		ResponseStructure<Book> responseStructure = new ResponseStructure<Book>();
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("Book Added Successfully...!");
		responseStructure.setData(bookRepository.save(modelMapper.map(bookDTO, Book.class)));

		return new ResponseEntity<ResponseStructure<Book>>(responseStructure, HttpStatus.CREATED);

	}

	// To get list of all books
	public ResponseEntity<ResponseStructure<List<Book>>> getAllBooks() {

		ResponseStructure<List<Book>> responseStructure = new ResponseStructure<List<Book>>();
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully get all books...!");
		responseStructure.setData(bookRepository.findAll());

		return new ResponseEntity<ResponseStructure<List<Book>>>(responseStructure, HttpStatus.OK);

	}

	// To get details of a specific book by ID
	public ResponseEntity<ResponseStructure<Book>> getBookById(long id) {

		ResponseStructure<Book> responseStructure = new ResponseStructure<Book>();
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully get book with id " + id);
		responseStructure.setData(
				bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException("Book Not Found at id " + id)));

		return new ResponseEntity<ResponseStructure<Book>>(responseStructure, HttpStatus.OK);

	}

	// To Update details of a book
	public ResponseEntity<ResponseStructure<Book>> updateBook(BookDTO bookDTO) {

		ResponseStructure<Book> responseStructure = new ResponseStructure<Book>();
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Book Updated Successfully...!");
		responseStructure.setData(bookRepository.save(modelMapper.map(bookDTO, Book.class)));

		return new ResponseEntity<ResponseStructure<Book>>(responseStructure, HttpStatus.OK);

	}

	// To delete a book by ID
	public ResponseEntity<ResponseStructure<Boolean>> deleteBookById(long id) {

		if (bookRepository.existsById(id)) {

			bookRepository.deleteById(id);

			ResponseStructure<Boolean> responseStructure = new ResponseStructure<Boolean>();
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Successfully delete book with id " + id);
			responseStructure.setData(true);

			return new ResponseEntity<ResponseStructure<Boolean>>(responseStructure, HttpStatus.OK);

		}

		throw new BookNotFoundException("Book Not Found at id " + id);

	}

}
