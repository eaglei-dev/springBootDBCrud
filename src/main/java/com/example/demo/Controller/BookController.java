package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Book.Book;
import com.example.demo.repository.BookRepository;

@RestController
@RequestMapping("/books")
public class BookController {
	@Autowired
	BookRepository bookRepo;
	
	@GetMapping("/")
	public List<Book> getBooks() {
		return bookRepo.findAll();
	}
	
	@RequestMapping( value = "/", method = RequestMethod.POST, consumes= {"application/json"} )
	public Book updateRecords(@RequestBody Book newBook) {
		bookRepo.save(newBook);
		return newBook;
	}
	
	
}
