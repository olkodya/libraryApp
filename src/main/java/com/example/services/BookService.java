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

    public void delete(Book book) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        try (session) {
            BookDAO bookDAO = new BookDAO(session);
            bookDAO.delete(book);
        }
    }

    public List<Book> findAll() {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        try (session) {
            BookDAO bookDAO = new BookDAO(session);
            return bookDAO.findAll();
        }
    }

    public List<Book> findByParameter(String param, Object value) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        try (session) {
            BookDAO bookDAO = new BookDAO(session);
            return bookDAO.findByParameter(param, value);
        }
    }

    public List<Book> findByAuthor(String value) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        try (session) {
            BookDAO bookDAO = new BookDAO(session);
            return bookDAO.findByAuthor(value);
        }
    }

}
