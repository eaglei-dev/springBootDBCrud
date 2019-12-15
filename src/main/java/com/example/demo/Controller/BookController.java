package com.example.demo.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Book;
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
	
	@RequestMapping( value = "/{id}", method = RequestMethod.GET)
	public Optional<Book> getBookById(@PathVariable("id") long id) {
		return bookRepo.findById(id);
	}
	
	@RequestMapping( value = "/", method = RequestMethod.POST, consumes= {"application/json"} )
	public Book addARecord(@RequestBody Book newBook) {
		bookRepo.save(newBook);
		return newBook;
	}
	
	@RequestMapping( value = "/{id}", method = RequestMethod.PATCH, consumes= {"application/json"} )
	public Book updateRecordById(@PathVariable("id") long id, @RequestBody Book bookToUpdate){
		Book bookRecordInStore = bookRepo.findById(id).get();
		bookRecordInStore.setTitle(bookToUpdate.getTitle());
		return bookRepo.save(bookRecordInStore);
	}
	
	@RequestMapping( value = "/{id}", method = RequestMethod.DELETE, consumes= {"application/json"} )
	public String deleteRecordById(@PathVariable("id") long id){
		bookRepo.deleteById(id);
		return "DELETED";
		
	}
}
