package com.example.dao;

import com.example.models.Borrow;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class BorrowDAO {
    Session session;

    public BorrowDAO(Session session) {
        this.session = session;

    }
    public Borrow findById(Long id) {
        return session.get(Borrow.class, id);
    }

    public void save(Borrow borrow) {
        Transaction transaction = session.beginTransaction();
        session.save(borrow);
        transaction.commit();
    }

    public void update(Borrow borrow) {
        Transaction transaction = session.beginTransaction();
        session.update(borrow);
        transaction.commit();
    }

    public void delete(Borrow borrow) {
        Transaction transaction = session.beginTransaction();
        session.delete(borrow);
        transaction.commit();
    }

    public List<Borrow> findAll() {
        return (List<Borrow>) session.createQuery("From Borrow").list();
    }
}
