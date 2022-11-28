package com.accolite.BookStore.service;

import com.accolite.BookStore.model.BookReview;
import com.accolite.BookStore.repository.BookReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class BookReviewServiceImpl implements BookReviewService {
    @Autowired
    private BookReviewRepository bookReviewRepository;

    @Override
    public BookReview addReview(BookReview bookReview){
        return bookReviewRepository.save(bookReview);
    }

    @Override
    public List<BookReview> getBookReview() {
        return this.bookReviewRepository.findAll();
    }
}