package com.example.services;

import com.example.dao.BookDAO;
import com.example.models.Book;

import java.util.List;

public class BookService {
    BookDAO bookDAO = new BookDAO();

    public Book findById(final Long id) {
        return bookDAO.findById(id);
    }

    public void save(Book book) {
        bookDAO.save(book);
    }

    public void update(Book book) {
        bookDAO.update(book);
    }

    public List<Book> findAll() {
        return bookDAO.findAll();
    }
}
