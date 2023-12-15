package com.example.services;

import com.example.dao.CopyDAO;
import com.example.models.Copy;
import com.example.utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;

import java.util.List;

public class CopyService {


    public Copy findById(final Long id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        CopyDAO copyDAO = new CopyDAO(session);
        try (session) {
            return copyDAO.findById(id);
        }
    }

    public void save(Copy copy) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        CopyDAO copyDAO = new CopyDAO(session);
        try (session) {
            copyDAO.save(copy);
        }
    }

    public void update(Copy copy) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        CopyDAO copyDAO = new CopyDAO(session);
        try (session) {
            copyDAO.update(copy);
        }
    }

    public void delete(Copy copy) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        CopyDAO copyDAO = new CopyDAO(session);
        try (session) {
            copyDAO.delete(copy);
        }
    }
    public List<Copy> findAll() {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        CopyDAO copyDAO = new CopyDAO(session);
        try (session) {
            return copyDAO.findAll();
        }
    }

    public List<Copy> findByParameter(String param, Object value) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        try (session) {
            CopyDAO copyDAO = new CopyDAO(session);
            return copyDAO.findByParameter(param, value);
        }
    }
}
