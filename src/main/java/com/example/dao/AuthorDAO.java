package com.example.dao;

import com.example.models.Author;
import com.example.utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class AuthorDAO {

    private Session session;

    public AuthorDAO(Session session) {
        this.session = session;

    }

    public Author findById(Long id) {
        return session.get(Author.class, id);
    }

    public void save(Author author) {
        Transaction transaction = session.beginTransaction();
        session.save(author);
        transaction.commit();
    }

    public void update(Author author) {
        Transaction transaction = session.beginTransaction();
        session.update(author);
        transaction.commit();
    }

    public void delete(Author author) {
        Transaction transaction = session.beginTransaction();
        session.delete(author);
        transaction.commit();
    }

    public List<Author> findAll() {
        return (List<Author>) HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From Author").list();
    }
}
