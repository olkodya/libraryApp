package com.example.services;

import com.example.dao.PublisherDAO;
import com.example.models.Publisher;
import com.example.utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.exception.ConstraintViolationException;

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
            try {
                publisherDAO.update(publisher);
            } catch (ConstraintViolationException exception) {
                System.out.println("This publisher already exists");
            }
        }
    }

    public void delete(Publisher publisher) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        PublisherDAO publisherDAO = new PublisherDAO(session);
        try (session) {
            publisherDAO.delete(publisher);
        }
    }
    public List<Publisher> findAll() {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        PublisherDAO publisherDAO = new PublisherDAO(session);
        try (session) {
            return publisherDAO.findAll();
        }
    }

    public List<Publisher> findByParameter(String param, Object value) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        try (session) {
            PublisherDAO publisherDAO = new PublisherDAO(session);
            return publisherDAO.findByParameter(param, value);
        }
    }


}
