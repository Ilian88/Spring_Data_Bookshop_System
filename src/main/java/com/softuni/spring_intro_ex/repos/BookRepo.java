package com.softuni.spring_intro_ex.repos;

import com.softuni.spring_intro_ex.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface BookRepo extends JpaRepository<Book,Long> {

    List<Book> getAllByReleaseDateAfter(LocalDate localDate);
}
