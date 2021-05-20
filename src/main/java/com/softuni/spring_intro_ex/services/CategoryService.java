package com.softuni.spring_intro_ex.services;

import com.softuni.spring_intro_ex.entities.Category;

import java.io.IOException;

public interface CategoryService {
    void seedCategories() throws IOException;

    Category getCategoryById(long id);
}
