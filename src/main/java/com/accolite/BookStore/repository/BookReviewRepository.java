package com.accolite.BookStore.repository;

import com.accolite.BookStore.model.BookReview;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookReviewRepository extends JpaRepository<BookReview,Long> {

}