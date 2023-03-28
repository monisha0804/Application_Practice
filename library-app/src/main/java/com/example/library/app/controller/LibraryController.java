package com.example.library.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.library.app.model.Books;
import com.example.library.app.service.LibraryService;

@RestController
@RequestMapping("/book")
public class LibraryController {

	@Autowired
	LibraryService libraryService;
	
	@PostMapping("/add")
	public Books addbook(@RequestBody Books deal) {
		return libraryService.save(deal);
	}
	
	@GetMapping("/findall")
	public List<Books> findall(){
		return libraryService.findall();
	}
	
	@GetMapping("/find/id/{id}")
	public Optional<Books> findById(@PathVariable ("id") String id) {
		return libraryService.findById(id);
	}
	
	@GetMapping("/find/title/{title}")
	public List<Optional<Books>> findByTitle(@PathVariable ("title") String title){
		return libraryService.findByTitle(title);
	}
	
	@GetMapping("/find/author/{authorName}")
	public List<Optional<Books>> findByAuthor(@PathVariable ("authorName") String author){
		return libraryService.findByAuthor(author);
	}
	
	@GetMapping("/find/genre/{genre}")
	public List<Optional<Books>> findByGenre(@PathVariable ("genre") String genre){
		return libraryService.findByGenre(genre);
	}
	
	@PutMapping("/update")
	public Books updateBook(@RequestBody Books deal) {
		return libraryService.save(deal);		 
	}

	@DeleteMapping("/delete/title/{title}")
	public String delete(@PathVariable String title){
		return libraryService.deleteByTitle(title);
		
	}
	
}


