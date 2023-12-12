package com.example.services;

import com.example.dao.CityDAO;
import com.example.models.City;
import com.example.utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;

import java.util.List;

public class CityService {


    public City findByID(final Long id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        CityDAO cityDAO = new CityDAO(session);
        try (session) {
            return cityDAO.findById(id);
        }
    }

    public void save(City city) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        CityDAO cityDAO = new CityDAO(session);
        try (session) {
            cityDAO.save(city);
        }
    }

    public void update(City city) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        CityDAO cityDAO = new CityDAO(session);
        try (session) {
            cityDAO.update(city);
        }
    }

    public void delete(City city) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        CityDAO cityDAO = new CityDAO(session);
        cityDAO.delete(city);
    }

    public List<City> findAll() {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        CityDAO cityDAO = new CityDAO(session);
        try (session) {
            return cityDAO.findAll();
        }
    }
}
