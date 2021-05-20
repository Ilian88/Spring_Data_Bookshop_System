package com.softuni.spring_intro_ex.services;


import com.softuni.spring_intro_ex.entities.Author;

import java.io.IOException;
import java.util.List;

public interface AuthorService {
    void seedAuthors() throws IOException;

    long getAllAuthorsCount();

    Author findAuthorById(long id);

    List<Author> findAllAuthorsByCountOfBooks();
}
