package com.accolite.BookStore.controller;

import com.accolite.BookStore.model.BookReview;
import com.accolite.BookStore.service.BookReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookReviewController {
    @Autowired
    private BookReviewService bookReviewService;

    @GetMapping("/addReview")
    private ResponseEntity<List<BookReview>> getAllBookReview(){
        return ResponseEntity.ok().body(this.bookReviewService.getBookReview());
    }

    @PostMapping("/addReview")
    private ResponseEntity<BookReview> addReview(@RequestBody BookReview bookReview){
        return ResponseEntity.ok().body(this.bookReviewService.addReview(bookReview));
    }

}
