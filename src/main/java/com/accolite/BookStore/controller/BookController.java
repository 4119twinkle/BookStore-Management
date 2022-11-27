package com.accolite.BookStore.controller;

import com.accolite.BookStore.model.Book;
import com.accolite.BookStore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/book")
    private ResponseEntity<List<Book>> getAllBooks(){

        return ResponseEntity.ok().body(this.bookService.getBook());
    }
    @GetMapping("/book/{bookId}")
    private Book getBookById(@PathVariable long bookId){

        return this.bookService.getBookById(bookId);
    }
    @PostMapping("/books")
    private ResponseEntity<Book> addBook(@RequestBody Book book){
        return ResponseEntity.ok().body(this.bookService.addBook(book));
    }
    @PutMapping("/book/{bookId}")
    private ResponseEntity<Book> updateBook(@PathVariable long bookId,@RequestBody Book book){
        book.setBook_id(bookId);
        return ResponseEntity.ok().body(this.bookService.updateBook(book));
    }
    @DeleteMapping("/book/{bookId}")
    private HttpStatus deleteBook(@PathVariable long bookId){
        this.bookService.deleteBook(bookId);
        return HttpStatus.OK;
    }
}
