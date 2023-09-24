package com.demo.bookshop.DemoBookShop.domain.repository;

import com.demo.bookshop.DemoBookShop.domain.Book;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class InMemoryBookRepository implements BookRepository {

    private static final Map<String, Book> books =
            new ConcurrentHashMap<>();


    @Override
    public Iterable<Book> findAll() {
        return books.values();
    }

    @Override
    public Optional<Book> findByIsbn(String isbn) {
        return existByIsbn(isbn) ? Optional.of(books.get(isbn)) : Optional.empty();
    }

    @Override
    public boolean existByIsbn(String isbn) {
        return books.get(isbn) != null;
    }

    @Override
    public Book save(Book book) {
        books.put(book.isbn(), book);
        return books.get(book.isbn());
    }

    @Override
    public void deleteByIsbn(String isbn) {
        books.remove(isbn);
    }
}