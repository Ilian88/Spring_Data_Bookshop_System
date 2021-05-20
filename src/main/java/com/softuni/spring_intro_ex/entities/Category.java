package com.softuni.spring_intro_ex.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table
public class Category extends BaseEntity {

    private String name;
    private Set<Book> books;

    public Category() {

    }

    public Category(String name) {
        this.name = name;
    }

    @ManyToMany(mappedBy = "categories",targetEntity = Book.class)
    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    @Column(name = "name",nullable = false,unique = true)
    public String getName() {
        return name;
    }

    public void setName(String firstName) {
        this.name = firstName;
    }
}
