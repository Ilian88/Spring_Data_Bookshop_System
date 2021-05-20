package com.softuni.spring_intro_ex.repos;

import com.softuni.spring_intro_ex.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepo extends JpaRepository<Author,Long> {

    @Query("SELECT a from Author a ORDER BY a.books.size DESC")
    List<Author> findAuthorByCountOfBooks();
}
