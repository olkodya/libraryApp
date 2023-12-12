package com.example.services;

import com.example.dao.PublisherDAO;
import com.example.models.Publisher;
import com.example.utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;

import java.util.List;

public class PublisherService {


    public Publisher findByID(final Long id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        PublisherDAO publisherDAO = new PublisherDAO(session);
        try (session) {
            return publisherDAO.findById(id);

        }
    }

    public void save(Publisher publisher) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        PublisherDAO publisherDAO = new PublisherDAO(session);
        try (session) {
            publisherDAO.save(publisher);
        }
    }

    public void update(Publisher publisher) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        PublisherDAO publisherDAO = new PublisherDAO(session);
        try (session) {
            publisherDAO.update(publisher);
        }
    }

    public List<Publisher> findAll() {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        PublisherDAO publisherDAO = new PublisherDAO(session);
        try (session) {
            return publisherDAO.findAll();
        }
    }
}
