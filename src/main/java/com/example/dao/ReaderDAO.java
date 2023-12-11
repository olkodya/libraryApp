package com.example.dao;

import com.example.models.Reader;
import com.example.utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ReaderDAO {
    public Reader findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Reader.class, id);
    }

    public void save(Reader reader) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(reader);
        transaction.commit();
        session.close();
    }

    public void update(Reader reader) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(reader);
        transaction.commit();
        session.close();
    }

    public void delete(Reader reader) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(reader);
        transaction.commit();
        session.close();
    }

    public List<Reader> findAll() {
        return (List<Reader>) HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From Reader").list();
    }

}
