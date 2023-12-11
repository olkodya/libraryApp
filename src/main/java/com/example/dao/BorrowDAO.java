package com.example.dao;

import com.example.models.Borrow;
import com.example.utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class BorrowDAO {
    public Borrow findById(Long id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Borrow.class, id);
    }

    public void save(Borrow borrow) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(borrow);
        transaction.commit();
        session.close();
    }

    public void update(Borrow borrow) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(borrow);
        transaction.commit();
        session.close();
    }

    public void delete(Borrow borrow) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(borrow);
        transaction.commit();
        session.close();
    }

    public List<Borrow> findAll() {
        return (List<Borrow>) HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From Borrow").list();
    }
}
