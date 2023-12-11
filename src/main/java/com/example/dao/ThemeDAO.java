package com.example.dao;

import com.example.models.Theme;
import com.example.utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ThemeDAO {
    public Theme findById(Long id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Theme.class, id);
    }

    public void save(Theme theme) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(theme);
        transaction.commit();
        session.close();
    }

    public void update(Theme theme) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(theme);
        transaction.commit();
        session.close();
    }

    public void delete(Theme theme) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(theme);
        transaction.commit();
        session.close();
    }

    public List<Theme> findAll() {
        return (List<Theme>) HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From Theme").list();
    }

}
