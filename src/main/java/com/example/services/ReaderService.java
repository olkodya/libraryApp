package com.example.services;

import com.example.dao.ReaderDAO;
import com.example.models.Reader;
import com.example.utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;

import java.util.List;

public class ReaderService {


    public Reader findById(final Long id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        ReaderDAO readerDAO = new ReaderDAO(session);
        try (session) {
            return readerDAO.findById(id);
        }
    }

    public void save(Reader reader) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        ReaderDAO readerDAO = new ReaderDAO(session);
        try (session) {
            readerDAO.save(reader);
        }
    }

    public void update(Reader reader) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        ReaderDAO readerDAO = new ReaderDAO(session);
        try (session) {
            readerDAO.update(reader);
        }
    }

    public void delete(Reader reader) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        ReaderDAO readerDAO = new ReaderDAO(session);
        try (session) {
            readerDAO.delete(reader);
        }
    }

    public List<Reader> findAll() {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        ReaderDAO readerDAO = new ReaderDAO(session);
        try (session) {
            return readerDAO.findAll();
        }
    }

    public List<Reader> findByParameter(String param, Object value) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        try (session) {
            ReaderDAO readerDAO = new ReaderDAO(session);
            return readerDAO.findByParameter(param, value);
        }
    }
}
