package com.softuni.spring_intro_ex;

import com.softuni.spring_intro_ex.entities.Author;
import com.softuni.spring_intro_ex.entities.Book;
import com.softuni.spring_intro_ex.services.AuthorService;
import com.softuni.spring_intro_ex.services.BookService;
import com.softuni.spring_intro_ex.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class AppController implements CommandLineRunner {

    private final CategoryService categoryService;
    private final AuthorService authorService;
    private final BookService bookService;

    @Autowired
    public AppController(CategoryService categoryService, AuthorService authorService, BookService bookService) {
        this.categoryService = categoryService;
        this.authorService = authorService;

        this.bookService = bookService;
    }

    @Override
    public void run(String... args) throws Exception {
        //seed data
        this.categoryService.seedCategories();
        this.authorService.seedAuthors();
        this.bookService.seedBooks();

        // Get all books after the year 2000. Print only their titles.
        List<Book> books = this.bookService.getAllBooksAfter2000();
        System.out.println("------------------------");
        System.out.println("Titles of all books after year of 2000 :");
        books.forEach(e-> System.out.printf("%s%n",e.getTitle()));
        System.out.println("------------------------");
        //Get all authors with at least one book with release date before 1990.
        // Print their first name and last name.
        List<Author> booksByNumber = this.authorService.findAllAuthorsByCountOfBooks();
        System.out.println("------------------------");
        System.out.println("Authors , ordered by number of books descending");
        booksByNumber.forEach(b -> System.out.printf("%s %s%n",b.getFirstName(),b.getLastName()));
        System.out.println("------------------------");


    }
}
