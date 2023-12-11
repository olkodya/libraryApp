package com.example.dao;

import com.example.models.City;
import com.example.utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class CityDAO {
    public City findById(Long id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(City.class, id);
    }

    public void save(City city) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(city);
        transaction.commit();
        session.close();
    }

    public void update(City city) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(city);
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

    public List<City> findAll() {
        return (List<City>) HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From City").list();
    }
}
