package com.api.book.bookrestbook.services;

import java.util.List;
//import java.util.stream.Collectors;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.api.book.bookrestbook.dao.BookRepository;
import com.api.book.bookrestbook.entities.Book;

@Component
public class BookService {
	
	@Autowired
	private BookRepository br;

//	private static List<Book> list = new ArrayList<>();
//	
//	static {
//		list.add(new Book(5,"Core Java","Ravi"));
//		list.add(new Book(10,"Adv Java","Hari"));
//		list.add(new Book(7,"Spring Boot","Natraj"));
//	}
	
	//get all book
	public List<Book> getAllBook(){
		List<Book> list = (List<Book>)this.br.findAll();
		return list;
	}
	
	//get book by id
	public  Book getBookById(int id) {
		//Book b =list.stream().filter(e->e.getId()==id).findFirst().get();
		 Optional<Book> optionalBook = Optional.ofNullable(this.br.findById(id));
	        return optionalBook.orElse(null); // return null if not found
	}
	//adding the book
	public Book addBook(Book b) {
		//list.add(b);
		b.setId(0);
		 return br.save(b);
	}
	
	public void deleteBook(int id) {
		//list = list.stream().filter(book ->book.getId() != id).collect(Collectors.toList());
		br.deleteById(id);
	}
	//update the book
	public void updateBook(Book book,int id) {
//		list.stream().map(b->{
//			if(b.getId() == id) {
//				b.setName(book.getName());
//				b.setAuthor(book.getAuthor());
//				b.setId(book.getId());
//			}
//			return b;
//		}).collect(Collectors.toList());
		 Optional<Book> optionalBook = Optional.ofNullable(br.findById(id));
	        if (optionalBook.isPresent()) {
	            Book existingBook = optionalBook.get();
	            existingBook.setName(book.getName());
	            existingBook.setAuthor(book.getAuthor());
	            br.save(existingBook);
	        } else {
	            throw new RuntimeException("Book with ID " + id + " not found.");
	        }
		
	}
}
