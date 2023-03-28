package com.example.library.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.library.app.exception.LibraryRequestException;
import com.example.library.app.model.Books;
import com.example.library.app.repository.LibraryRepository;

@Service
public class LibraryService {
	
	@Autowired
	private LibraryRepository libraryRepository;

	public Books save(Books deal) {
		return libraryRepository.save(deal);
	}

	public List<Books> findall() {		
		return libraryRepository.findAll();
	}

	public Optional<Books> findById(String id) {
		Optional<Books> book = libraryRepository.findById(id);
		if(book.isEmpty()) {
			throw new LibraryRequestException("Id not found");
		}
		else {
			return book;
		}
	}

	public List<Optional<Books>> findByAuthor(String author) {
		List<Optional<Books>> book = libraryRepository.findByAuthor(author);
		if(book.isEmpty()) {
			throw new LibraryRequestException("Author not found");
		}
		else {
			return book;
		}
	}

	public List<Optional<Books>> findByGenre(String genre) {
		List<Optional<Books>> book = libraryRepository.findByGenre(genre);
		if(book.isEmpty()) {
			throw new LibraryRequestException("Genre not found");
		}
		else {
			return book;
		}
	}

	public List<Optional<Books>> findByTitle(String title) {
		List<Optional<Books>> book =  libraryRepository.findByTitle(title);
		if(book.isEmpty()) {			
		 throw new LibraryRequestException("Title is not found");
		}
		else {
			return book;
		}
	}

	public String deleteByTitle(String title) {
		List<Optional<Books>> book = libraryRepository.findByTitle(title);
		if(book.size()>0) {
			for(Optional<Books> books: book) {
				libraryRepository.deleteByTitle(books.get().getTitle());
			}
				return "book deleted";
		}
		else {
			return "Title not found";
		}
	}


}
