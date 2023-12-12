package com.example.dao;

import com.example.models.Publisher;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class PublisherDAO {

    private final Session session;

    public PublisherDAO(Session session) {
        this.session = session;

    }
    public Publisher findById(Long id) {
        return session.get(Publisher.class, id);
    }

    public void save(Publisher publisher) {
        Transaction transaction = session.beginTransaction();
        session.save(publisher);
        transaction.commit();
    }

    public void update(Publisher publisher) {
        Transaction transaction = session.beginTransaction();
        session.update(publisher);
        transaction.commit();
    }

    public void delete(Publisher publisher) {
        Transaction transaction = session.beginTransaction();
        session.delete(publisher);
        transaction.commit();
    }

    public List<Publisher> findAll() {
        return (List<Publisher>) session.createQuery("From Publisher").list();
    }
}
