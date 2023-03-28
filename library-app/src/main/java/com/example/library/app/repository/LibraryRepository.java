package com.example.library.app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.library.app.model.Books;

@Repository
public interface LibraryRepository extends MongoRepository<Books,String>{

	Optional<Books> findById(String id);

	List<Optional<Books>> findByAuthor(String author);

	List<Optional<Books>> findByGenre(String genre);

	List<Optional<Books>> findByTitle(String title);

	void deleteByTitle(String title);

	

	
}
