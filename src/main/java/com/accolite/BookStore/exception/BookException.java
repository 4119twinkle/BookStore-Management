package com.accolite.BookStore.exception;

import com.accolite.BookStore.model.Book;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class BookException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public BookException(String message){
        super(message);
    }
    public BookException(String message,Throwable throwable){
        super(message,throwable);
    }
}
