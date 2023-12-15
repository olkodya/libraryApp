package com.example.dao;

import com.example.models.Author;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class AuthorDAO {

    private final Session session;

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
        return (List<Author>) session.createQuery("From Author order by id").list();
    }

    public List<Author> findByParameter(String param, Object value) {
        Transaction transaction = session.beginTransaction();
        String hql = String.format("from Author where upper(%s) like upper(:param)", param);
        Query<Author> query = session.createQuery(hql, Author.class);
        query.setParameter("param", "%" + value + "%");
        return query.list();
    }
}
