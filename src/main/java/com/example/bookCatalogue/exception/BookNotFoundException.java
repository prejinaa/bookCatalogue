package com.example.bookCatalogue.exception;

import java.io.Serial;
import java.io.Serializable;

public class BookNotFoundException extends Exception{
    @Serial

    private static final long serialVersionUID = 1L;

    public BookNotFoundException() {
    }

    public BookNotFoundException(String message) {
        super(message);
    }
}
