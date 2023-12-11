package com.example.dao;

import com.example.models.Author;
import com.example.utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class AuthorDAO {
    public Author findById(Long id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Author.class, id);
    }

    public void save(Author author) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(author);
        transaction.commit();
        session.close();
    }

    public void update(Author author) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(author);
        transaction.commit();
        session.close();
    }

    public void delete(Author author) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(author);
        transaction.commit();
        session.close();
    }

    public List<Author> findAll() {
        return (List<Author>) HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From Author").list();
    }
}
