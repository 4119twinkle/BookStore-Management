package com.accolite.BookStore.service;

import com.accolite.BookStore.exception.BookException;
import com.accolite.BookStore.model.Book;
import com.accolite.BookStore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BookServiceImpl implements BookService{

    @Autowired
    private BookRepository bookRepository;

    @Override
    public Book addBook(Book b) {
        return bookRepository.save(b);
    }

    @Override
    public Book updateBook(Book b) {
        Optional<Book> bookObj = this.bookRepository.findById(b.getBook_id());

        if(bookObj.isPresent()){
            Book bookUpdate = bookObj.get();
            bookUpdate.setBook_id(b.getBook_id());
            bookUpdate.setBook_name(b.getBook_name());
            bookUpdate.setBook_cost(b.getBook_cost());
            bookUpdate.setBook_author(b.getBook_author());
            bookUpdate.setBook_category(b.getBook_category());
            bookUpdate.setBook_review(b.getBook_review());
            return this.bookRepository.save(bookUpdate);
        }
        else{
            throw new BookException("Book didn't found with Id:"+b.getBook_id());
        }
    }

    @Override
    public List<Book> getBook() {

        return this.bookRepository.findAll();
    }

    @Override
    public Book getBookById(long book_id) {
        Optional<Book> bookObj = this.bookRepository.findById(book_id);
        if(bookObj.isPresent()){
            return bookObj.get();
        }else{
            throw new BookException("Book didn't found with Id:"+book_id);
        }
    }
    @Override
    public List<Book> sortByLike() {
        List<Book> BookByLike=this.bookRepository.findAll();

        Collections.sort(BookByLike, new Comparator<Book>() {
            @Override
            public int compare(Book b1, Book b2) {
                return b1.getBookLikes() - b2.getBookLikes();
            }
        });
        return BookByLike;
    }
    @Override
    public void deleteBook(long book_id) {
        Optional<Book> bookObj = this.bookRepository.findById(book_id);
        if(bookObj.isPresent()){
            this.bookRepository.deleteById(book_id);
        }
        else{
            throw new BookException("Book didn't found with Id:"+book_id);
        }

    }
}
