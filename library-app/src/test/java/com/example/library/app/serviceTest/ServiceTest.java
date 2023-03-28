package com.example.library.app.serviceTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.library.app.model.Books;
import com.example.library.app.repository.LibraryRepository;
import com.example.library.app.service.LibraryService;

@SpringBootTest
public class ServiceTest {

	@Autowired
	private LibraryService libraryService;
	
	@MockBean
	private LibraryRepository libraryRepository;
	
	@Test
	public void save() {
		Books book = new Books("1","The Secret","Motivational","Rhonda byrne");
		when(libraryRepository.save(book)).thenReturn(book);
		assertEquals(book,libraryService.save(book));
		
	}
}
