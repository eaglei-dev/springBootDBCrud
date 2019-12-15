package com.example.demo;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.model.Author;
import com.example.demo.repository.AuthorRepository;

@SpringBootApplication
public class SpringBootDbCrudApplication {
	@Autowired
	private AuthorRepository authorRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDbCrudApplication.class, args);
	}
	
	// @PostConstruct
	// public void createAuthorData() {
	//	Author newAuthor = new Author(1,"Paulo","Choelo");
	//	
	//	authorRepository.save(newAuthor);
	// }

}
