package com.example.dao;

import com.example.models.City;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class CityDAO {
    private Session session;

    public CityDAO(Session session) {
        this.session = session;

    }
    public City findById(Long id) {
        return session.get(City.class, id);
    }

    public void save(City city) {
        Transaction transaction = session.beginTransaction();
        session.save(city);
        transaction.commit();
    }

    public void update(City city) {
        Transaction transaction = session.beginTransaction();
        session.update(city);
        transaction.commit();
    }

    public void delete(City city) {
        Transaction transaction = session.beginTransaction();
        session.delete(city);
        transaction.commit();
    }

    public List<City> findAll() {
        return (List<City>) session.createQuery("From City").list();
    }
}
