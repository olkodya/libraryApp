package com.example.dao;

import com.example.models.City;
import com.example.models.Copy;
import com.example.utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class CopyDAO {
    public Copy findById(Long id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Copy.class, id);
    }

    public void save(Copy copy) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(copy);
        transaction.commit();
        session.close();
    }

    public void update(Copy copy) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(copy);
        transaction.commit();
        session.close();
    }

    public void delete(City city) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(city);
        transaction.commit();
        session.close();
    }

    public List<Copy> findAll() {
        return (List<Copy>) HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From Copy").list();
    }
}
