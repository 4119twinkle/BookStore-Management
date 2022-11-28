package com.accolite.BookStore.service;

import com.accolite.BookStore.model.BookReview;

import java.util.List;

public interface BookReviewService {

    BookReview addReview(BookReview bookReview);

    List<BookReview> getBookReview();
}