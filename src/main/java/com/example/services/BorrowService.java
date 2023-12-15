package com.example.services;

import com.example.dao.BorrowDAO;
import com.example.models.Borrow;
import com.example.models.Copy;
import com.example.utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;

import java.time.LocalDateTime;
import java.util.List;

public class BorrowService {


    public Borrow findById(final Long id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        BorrowDAO borrowDAO = new BorrowDAO(session);
        try (session) {
            return borrowDAO.findById(id);
        }
    }

    public void save(Borrow borrow) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        BorrowDAO borrowDAO = new BorrowDAO(session);
        try (session) {
            borrowDAO.save(borrow);
        }
    }

    public void update(Borrow borrow) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        BorrowDAO borrowDAO = new BorrowDAO(session);
        try (session) {
            borrowDAO.update(borrow);
        }
    }

    public void delete(Borrow borrow) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        BorrowDAO borrowDAO = new BorrowDAO(session);
        try (session) {
            borrowDAO.delete(borrow);
        }
    }

    public List<Borrow> findAll() {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        BorrowDAO borrowDAO = new BorrowDAO(session);
        try (session) {
            return borrowDAO.findAll();
        }
    }

    public List<Borrow> findByParameter(String param, Object value) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        try (session) {
            BorrowDAO borrowDAO = new BorrowDAO(session);
            return borrowDAO.findByParameter(param, value);
        }
    }

    public List<Borrow> findByCopy(Copy copy) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        try (session) {
            BorrowDAO borrowDAO = new BorrowDAO(session);
            return borrowDAO.findByCopy(copy);
        }
    }

    public List<Borrow> findByDate(String param, LocalDateTime value) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        try (session) {
            BorrowDAO borrowDAO = new BorrowDAO(session);
            return borrowDAO.findByDate(param, value);
        }
    }
}
