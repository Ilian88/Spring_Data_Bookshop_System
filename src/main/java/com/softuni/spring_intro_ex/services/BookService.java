package com.softuni.spring_intro_ex.services;

import com.softuni.spring_intro_ex.entities.Book;

import java.io.IOException;
import java.util.List;

public interface BookService {
    void seedBooks() throws IOException;

    List<Book> getAllBooksAfter2000();

}
