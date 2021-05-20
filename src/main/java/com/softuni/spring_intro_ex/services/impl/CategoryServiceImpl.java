package com.softuni.spring_intro_ex.services.impl;

import com.softuni.spring_intro_ex.constants.GlobalConstants;
import com.softuni.spring_intro_ex.entities.Category;
import com.softuni.spring_intro_ex.repos.CategoryRepo;
import com.softuni.spring_intro_ex.services.CategoryService;
import com.softuni.spring_intro_ex.utils.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Arrays;

import static com.softuni.spring_intro_ex.constants.GlobalConstants.CATEGORIES_FILE_PATH;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepo categoryRepo;
    private final FileUtil fileUtil;

    @Autowired
    public CategoryServiceImpl(CategoryRepo categoryRepo, FileUtil fileUtil) {
        this.categoryRepo = categoryRepo;
        this.fileUtil = fileUtil;
    }

    @Override
    public void seedCategories() throws IOException {
        if (this.categoryRepo.count() != 0) {
            return;
        }

        String[] fileContent = this.fileUtil.readFileContent(CATEGORIES_FILE_PATH);

        Arrays.stream(fileContent)
                .forEach(r -> {
                    Category category = new Category(r);

                    this.categoryRepo.saveAndFlush(category);

                });


    }

    @Override
    public Category getCategoryById(long id) {
        return this.categoryRepo.getOne(id);
    }
}
