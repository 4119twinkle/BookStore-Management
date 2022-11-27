package com.accolite.BookStore.service;

import com.accolite.BookStore.model.Book;

import java.util.List;

public interface BookService {
    //Book createBook(Book b);

    Book addBook(Book book);

    Book updateBook(Book b);

    List<Book> getBook();

    Book getBookById(long book_id);

    List<Book> sortByLike();


    void deleteBook(long book_id);
}
