package com.rahul.bookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rahul.bookstore.dto.BookDTO;
import com.rahul.bookstore.entity.Book;
import com.rahul.bookstore.response.structure.ResponseStructure;
import com.rahul.bookstore.service.BookService;

@RestController
@RequestMapping("api/v2/book")
public class BookController {

	@Autowired
	private BookService bookService;

	// To add a new Book
	@PostMapping
	public ResponseEntity<ResponseStructure<Book>> saveBook(@RequestBody BookDTO bookDTO) {

		return bookService.addBook(bookDTO);
	}

	// To get a list of all books
	@GetMapping
	public ResponseEntity<ResponseStructure<List<Book>>> getAllBooks() {

		return bookService.getAllBooks();
	}

	// To get details of a specific book by ID
	@GetMapping("/bookId/{id}")
	public ResponseEntity<ResponseStructure<Book>> getBookById(@PathVariable long id) {

		return bookService.getBookById(id);
	}

	// To update details of a book
	@PutMapping
	public ResponseEntity<ResponseStructure<Book>> updateBook(@RequestBody BookDTO bookDTO) {

		return bookService.updateBook(bookDTO);
	}

	// To delete details of a specific book by ID
	@DeleteMapping("/bookId/{id}")
	public ResponseEntity<ResponseStructure<Boolean>> deleteBookById(@PathVariable long id) {

		return bookService.deleteBookById(id);
	}

}
