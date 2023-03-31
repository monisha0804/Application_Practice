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
	
	@Test
	public void findByIdTest() {
		when (libraryRepository.findById("2")).thenReturn(Optional.of(new Books("1","The Secret","Motivational","Rhonda byrne")));
		Optional<Books> cou = libraryService.findById("2");
		assertEquals("1", cou.get().getId());
		assertEquals("The Secret",cou.get().getTitle());
		assertEquals("Motivational",cou.get().getGenre());
		assertEquals("Rhonda byrne",cou.get().getAuthor());
	}
	
		@Test
	public void findByAuthorTest() {
		Optional<Books> b1=Optional.of(new Books("1","The Secret","Motivational","Rhonda byrne"));
		Optional<Books> b2=Optional.of(new Books("2","The Secret part 1","Motivational","Rhonda byrne"));
		List<Optional<Books>> book= new ArrayList<>();
		book.add(b1);
		book.add(b2);
		when(libraryRepository.findByAuthor("Rhonda byrne")).thenReturn(book);
		assertEquals(libraryService.findByAuthor("Rhonda byrne").size(),2);		
	}	
	
}
