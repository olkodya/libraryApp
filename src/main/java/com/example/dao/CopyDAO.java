package com.example.dao;

import com.example.models.City;
import com.example.models.Copy;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class CopyDAO {
    private final Session session;

    public CopyDAO(Session session) {
        this.session = session;

    }
    public Copy findById(Long id) {
        return session.get(Copy.class, id);
    }

    public void save(Copy copy) {
        Transaction transaction = session.beginTransaction();
        session.save(copy);
        transaction.commit();
    }

    public void update(Copy copy) {
        Transaction transaction = session.beginTransaction();
        session.update(copy);
        transaction.commit();
    }

    public void delete(City city) {
        Transaction transaction = session.beginTransaction();
        session.delete(city);
        transaction.commit();
    }

    public List<Copy> findAll() {
        return (List<Copy>) session.createQuery("From Copy").list();
    }
}
