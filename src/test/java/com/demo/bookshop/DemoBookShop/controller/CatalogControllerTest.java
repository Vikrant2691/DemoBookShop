package com.demo.bookshop.DemoBookShop.controller;

import com.demo.bookshop.DemoBookShop.domain.BookService;
import com.demo.bookshop.DemoBookShop.domain.exception.BookNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(CatalogController.class)
class CatalogControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    BookService bookService;

    @Test
    public void whenBookNotExistsThenReturn404() throws Exception {
        String isbn = "73737313940";

        given(bookService.viewBookDetails(isbn))
                .willThrow(BookNotFoundException.class);

        mockMvc
                .perform(get("/books/" + isbn))
                .andExpect(status().isNotFound());

    }


}