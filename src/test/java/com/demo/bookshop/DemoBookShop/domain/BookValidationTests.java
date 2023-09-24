package com.demo.bookshop.DemoBookShop.domain;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;


public class BookValidationTests {

    private static Validator validator;

    @BeforeAll
    static void setUp(){
        ValidatorFactory validatorFactory= Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.getValidator();
    }

    @Test
    void whenAllFieldsCorrectThanValidationSucceeds(){
        var book = new Book("10293994","Title","somebody",10.99);

        Set<ConstraintViolation<Book>> violations = validator.validate(book);

        assertThat(violations).hasSize(1);
        assertThat(violations.iterator().next().getMessage())
                .isEqualTo("The ISBN format must be valid");

    }

}
