package com.rahul.bookstore.dto;

import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDTO {

	@Id
	private long id;

	@NotNull(message = "Title Cannot be Null")
	@Size(min = 2, message = "Please Give Valid Title Name")
	@NotBlank
	private String title;

	@NotNull(message = "Author Cannot be Null")
	@Size(min = 2, message = "Please Give Valid Author Name")
	@NotBlank
	private String author;

	@NotNull(message = "Price Cannot be Null")
	@Size(min = 0, message = "Price Cannot be Negative")
	@NotBlank
	private double price;

}
