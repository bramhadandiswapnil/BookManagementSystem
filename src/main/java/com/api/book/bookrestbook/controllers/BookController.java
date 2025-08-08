package com.api.book.bookrestbook.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.api.book.bookrestbook.entities.Book;
import com.api.book.bookrestbook.services.BookService;

@RestController
public class BookController {

    @Autowired
    private BookService bs;

    // Get all books
    @GetMapping("/books")
    public List<Book> getBooks() {
        return bs.getAllBook();
    }

    // Get a book by ID
    @GetMapping("/books/{id}")
    public ResponseEntity<Book> getBook(@PathVariable("id") int  id) {
        Book book = bs.getBookById(id);
        if (book == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(book);
    }

    // Add a new book
    @PostMapping("/books")
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        if (book.getId() != 0) {
            return ResponseEntity.badRequest().body(null);
        }
        Book savedBook = bs.addBook(book);
        return ResponseEntity.ok(savedBook);
    }


    // Delete a book by ID
    @DeleteMapping("/books/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable("id") int  id) {
        Book existingBook = bs.getBookById(id);
        if (existingBook == null) {
            return ResponseEntity.notFound().build();
        }
        bs.deleteBook(id);
        return ResponseEntity.noContent().build();
    }

    // Update a book
    @PutMapping("/books/{id}")
    public ResponseEntity<Book> updateBook(@RequestBody Book book, @PathVariable("id") int  id) {
        Book existingBook = bs.getBookById(id);
        if (existingBook == null) {
            return ResponseEntity.notFound().build();
        }
        bs.updateBook(book, id);
        return ResponseEntity.ok(book);
    }
}
