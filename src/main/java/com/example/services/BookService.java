package com.example.services;

import com.example.dao.BookDAO;
import com.example.models.Book;
import com.example.utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;

import java.util.List;

public class BookService {
    //BookDAO bookDAO = new BookDAO();

    public Book findById(final Long id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        try (session) {
            BookDAO bookDAO = new BookDAO(session);
            return bookDAO.findById(id);
        }

    }

    public void save(Book book) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        try (session) {
            BookDAO bookDAO = new BookDAO(session);
            bookDAO.save(book);
        }
    }

    public void update(Book book) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        try (session) {
            BookDAO bookDAO = new BookDAO(session);
            bookDAO.update(book);
        }
    }

    public List<Book> findAll() {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        try (session) {
            BookDAO bookDAO = new BookDAO(session);
            return bookDAO.findAll();
        }
    }
}
