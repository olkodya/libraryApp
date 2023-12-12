package com.example.services;

import com.example.dao.AuthorDAO;
import com.example.models.Author;
import com.example.utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;

import java.util.List;

public class AuthorService {

    //AuthorDAO authorDAO = new AuthorDAO();

    public Author findById(final Long id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        try (session) {
            AuthorDAO authorDAO = new AuthorDAO(session);
            return authorDAO.findById(id);
        }
    }

    public void save(Author author) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        AuthorDAO authorDAO = new AuthorDAO(session);
        try (session) {
            authorDAO.save(author);
        }
    }

    public void update(final Long id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        AuthorDAO authorDAO = new AuthorDAO(session);
        Author author = findById(id);
        authorDAO.update(author);

    }

    public List<Author> findAll() {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        try (session) {
            AuthorDAO authorDAO = new AuthorDAO(session);
            return authorDAO.findAll();
        }
    }
}
