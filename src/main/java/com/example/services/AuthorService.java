package com.example.services;

import com.example.dao.AuthorDAO;
import com.example.models.Author;

import java.util.List;

public class AuthorService {
    AuthorDAO authorDAO = new AuthorDAO();

    public Author findById(final Long id) {
        return authorDAO.findById(id);
    }

    public void save(Author author) {
        authorDAO.save(author);
    }

    public void update(Author author) {
        authorDAO.update(author);
    }

    public List<Author> findAll() {
        return authorDAO.findAll();
    }
}
