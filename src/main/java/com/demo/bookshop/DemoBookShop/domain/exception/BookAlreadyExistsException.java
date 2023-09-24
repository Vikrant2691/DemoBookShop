package com.demo.bookshop.DemoBookShop.domain.exception;

public class BookAlreadyExistsException extends RuntimeException{
    public BookAlreadyExistsException(String isbn) {
        System.out.printf("Book with ISBN %s already exists %n", isbn);
    }
}
