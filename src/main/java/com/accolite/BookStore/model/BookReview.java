package com.accolite.BookStore.model;

import javax.persistence.*;

@Entity
@Table(name="bookreview")
public class BookReview {
    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)

    @Column(name="review_id")
    long review_id;
    @Column(name="book_Id")
    long book_Id;
    @Column(name="user_id")
    long user_id;
    @Column(name="review")
    String review;

    public long getReviewId() {
        return review_id;
    }

    public void setReviewId(long review_id) {
        this.review_id = review_id;
    }

    public long getBookId() {
        return book_Id;
    }

    public void setBookId(long bookId) {
        this.book_Id = bookId;
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    @Override
    public String toString() {
        return "BookReview{" +
                "reviewId=" + review_id +
                ", book_Id=" + book_Id +
                ", user_id=" + user_id +
                ", review='" + review + '\'' +
                '}';
    }
}
