package com.demo.bookshop.DemoBookShop.domain;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;

import static org.assertj.core.api.Assertions.assertThat;

@JsonTest
public class BookJsonTests {

    @Autowired
    private JacksonTester<Book> json;

    @Test
    void testSerialize() throws Exception {
        var book = Book.of("1234567890", "Polarsophia.", "SomeTitle", "SomeAuthor", 10.99);

        var jsonContent = json.write(book);

        assertThat(jsonContent).extractingJsonPathStringValue("@.isbn")
                .isEqualTo(book.isbn());
        assertThat(jsonContent).extractingJsonPathStringValue("@.title")
                .isEqualTo(book.title());
        assertThat(jsonContent).extractingJsonPathStringValue("@.author")
                .isEqualTo(book.author());
        assertThat(jsonContent).extractingJsonPathNumberValue("@.price")
                .isEqualTo(book.price());

    }

    @Test
    void testDeserialize() throws Exception {

        var content = """
                {
                    "isbn": "1231231232",
                    "title": "A life Journey",
                    "author": "someguy",
                    "price": 11.99
                }
                """;

        assertThat(json.parse(content))
                .usingRecursiveComparison()
                .isEqualTo(Book.of("1231231232", "Polarsophia", "A life Journey", "someguy", 11.99));
    }

}
