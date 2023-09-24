package com.demo.bookshop.DemoBookShop.domain.exception;

public class BookNotFoundException extends RuntimeException {
    public BookNotFoundException(String isbn) {
        System.out.printf("Book with ISBN %s not found %n", isbn);
    }
}
