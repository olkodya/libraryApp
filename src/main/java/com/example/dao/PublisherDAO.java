package com.example.dao;

import com.example.models.Publisher;
import com.example.utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class PublisherDAO {
    public Publisher findById(Long id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Publisher.class, id);
    }

    public void save(Publisher publisher) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(publisher);
        transaction.commit();
        session.close();
    }

    public void update(Publisher publisher) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(publisher);
        transaction.commit();
        session.close();
    }

    public void delete(Publisher publisher) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(publisher);
        transaction.commit();
        session.close();
    }

    public List<Publisher> findAll() {
        return (List<Publisher>) HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From Publisher").list();
    }
}
