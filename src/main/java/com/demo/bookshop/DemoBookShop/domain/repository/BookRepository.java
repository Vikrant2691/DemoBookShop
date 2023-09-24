package com.demo.bookshop.DemoBookShop.domain.repository;

import com.demo.bookshop.DemoBookShop.domain.Book;

import java.util.Optional;

public interface BookRepository{
    Iterable<Book> findAll();
    Optional<Book> findByIsbn(String isbn);
    boolean existByIsbn(String isbn);
    Book save(Book book);
    void deleteByIsbn(String isbn);
}
