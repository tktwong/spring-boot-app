package com.appswalker.nplusone.example.service;

import com.appswalker.nplusone.example.model.Book;
import com.appswalker.nplusone.example.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public List<Book> getBookList() {
        return bookRepository.findAll();
    }
}
