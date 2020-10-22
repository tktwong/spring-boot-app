package com.appswalker.nplusone.example.controller;

import com.appswalker.nplusone.example.model.Book;
import com.appswalker.nplusone.example.model.House;
import com.appswalker.nplusone.example.service.BookService;
import com.appswalker.nplusone.example.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping("/bookList")
    public List<Book> getBookList() {
        return bookService.getBookList();
    }
}
