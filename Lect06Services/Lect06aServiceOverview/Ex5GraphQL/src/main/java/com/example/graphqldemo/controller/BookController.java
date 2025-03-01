package com.example.graphqldemo.controller;

import com.example.graphqldemo.model.Book;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.Arrays;
import java.util.List;

@Controller
public class BookController {

    private List<Book> books = Arrays.asList(
            new Book("book-1", "Effective Java", 416, "Joshua Bloch"),
            new Book("book-2", "Thinking in Java", 1150, "Bruce Eckel"),
            new Book("book-3", "Clean Code", 464, "Robert C. Martin")
    );

    @QueryMapping
    public Book bookById(@Argument String id) {
        return books.stream()
                .filter(book -> book.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @QueryMapping
    public List<Book> allBooks() {
        return books;
    }
}