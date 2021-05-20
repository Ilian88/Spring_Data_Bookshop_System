package com.softuni.spring_intro_ex.services.impl;

import com.softuni.spring_intro_ex.constants.GlobalConstants;
import com.softuni.spring_intro_ex.entities.Author;
import com.softuni.spring_intro_ex.repos.AuthorRepo;
import com.softuni.spring_intro_ex.repos.CategoryRepo;
import com.softuni.spring_intro_ex.services.AuthorService;
import com.softuni.spring_intro_ex.utils.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static com.softuni.spring_intro_ex.constants.GlobalConstants.AUTHOR_FILE_PATH;

@Service
public class AuthorServiceImpl implements AuthorService {

   private final AuthorRepo authorRepo;
   private final FileUtil fileUtil;

   @Autowired
    public AuthorServiceImpl(AuthorRepo authorRepo, FileUtil fileUtil) {
        this.authorRepo = authorRepo;
        this.fileUtil = fileUtil;
    }

    @Override
    public void seedAuthors() throws IOException {
        if(authorRepo.count() != 0) {
            return;
        }

        String[] fileContent = fileUtil.readFileContent(AUTHOR_FILE_PATH);

        Arrays.stream(fileContent)
                .forEach(a -> {
                    String[] params = a.split("\\s+");
                    Author author = new Author(params[0],params[1]);

                    this.authorRepo.saveAndFlush(author);
                });


    }

    @Override
    public long getAllAuthorsCount() {
        return this.authorRepo.count();
    }

    @Override
    public Author findAuthorById(long id) {
        return this.authorRepo.getOne(id);
    }

    @Override
    public List<Author> findAllAuthorsByCountOfBooks() {
        return this.authorRepo.findAuthorByCountOfBooks();
    }
}
