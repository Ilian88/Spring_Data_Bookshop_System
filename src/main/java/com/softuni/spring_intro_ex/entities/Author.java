package com.softuni.spring_intro_ex.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table
public class Author extends BaseEntity{
    private String firstName;
    private String lastName;
    Set<Book> books;

    public Author() {
    }

    public Author(String fname,String lname) {
        this.firstName = fname;
        this.lastName = lname;
    }


    @OneToMany(mappedBy = "author",targetEntity = Book.class)
    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    @Column(name = "first_name")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "last_name",nullable = false)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
