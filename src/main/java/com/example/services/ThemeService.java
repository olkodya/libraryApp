package com.example.services;

import com.example.dao.ThemeDAO;
import com.example.models.Theme;
import com.example.utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;

import java.util.List;

public class ThemeService {


    public Theme findById(final Long id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        ThemeDAO themeDAO = new ThemeDAO(session);
        try (session) {
            return themeDAO.findById(id);
        }

    }

    public void save(Theme theme) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        ThemeDAO themeDAO = new ThemeDAO(session);
        try (session) {
            themeDAO.save(theme);
        }
    }

    public void update(Theme theme) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        ThemeDAO themeDAO = new ThemeDAO(session);
        try (session) {
            themeDAO.update(theme);
        }
    }

    public void delete(Theme theme) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        ThemeDAO themeDAO = new ThemeDAO(session);
        try (session) {
            themeDAO.delete(theme);
        }
    }

    public List<Theme> findAll() {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        ThemeDAO themeDAO = new ThemeDAO(session);
        try (session) {
            return themeDAO.findAll();
        }
    }
}
