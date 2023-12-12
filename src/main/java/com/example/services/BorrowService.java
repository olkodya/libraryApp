package com.example.services;

import com.example.dao.BorrowDAO;
import com.example.models.Borrow;
import com.example.utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;

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

    public List<Borrow> findAll() {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        BorrowDAO borrowDAO = new BorrowDAO(session);
        try (session) {
            return borrowDAO.findAll();
        }
    }
}
