package com.demo.bookshop.DemoBookShop.controller;

import com.demo.bookshop.DemoBookShop.domain.Book;
import com.demo.bookshop.DemoBookShop.domain.BookService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("books")
public class CatalogController {

    private final BookService bookService;

    public CatalogController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public Iterable<Book> get(){
        return bookService.viewBookList();
    }

    @GetMapping("{isbn}")
    public Book getByIsbn(@PathVariable String isbn){
        return bookService.viewBookDetails(isbn);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Book post(@Valid @RequestBody Book book){
        return bookService.addBookToCatalog(book);
    }

    @PutMapping("{isbn}")
    public Book put(@PathVariable String isbn,@Valid @RequestBody Book book){
        return bookService.editBookDetails(isbn,book);
    }

    @DeleteMapping("{isbn}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(String isbn){
        bookService.removeBookFromCatalog(isbn);
    }


}
