package com.example.dao;

import com.example.models.Borrow;
import com.example.models.Copy;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.time.LocalDateTime;
import java.util.List;

public class BorrowDAO {
    Session session;

    public BorrowDAO(Session session) {
        this.session = session;

    }
    public Borrow findById(Long id) {
        return session.get(Borrow.class, id);
    }

    public void save(Borrow borrow) {
        Transaction transaction = session.beginTransaction();
        session.save(borrow);
        transaction.commit();
    }

    public void update(Borrow borrow) {
        Transaction transaction = session.beginTransaction();
        session.update(borrow);
        transaction.commit();
    }

    public void delete(Borrow borrow) {
        Transaction transaction = session.beginTransaction();
        session.delete(borrow);
        transaction.commit();
    }

    public List<Borrow> findAll() {
        return (List<Borrow>) session.createQuery("From Borrow order by id").list();
    }

    public List<Borrow> findByParameter(String param, Object value) {
        Transaction transaction = session.beginTransaction();
        String hql = String.format("from Borrow where upper(%s) like upper(:param)", param);
        Query<Borrow> query = session.createQuery(hql, Borrow.class);
        query.setParameter("param", "%" + value + "%");
        return query.list();
    }


    public List<Borrow> findByCopy(Copy copy) {
        Transaction transaction = session.beginTransaction();
        String hql = String.format("from Borrow where copy = :param order by id DESC");
        Query<Borrow> query = session.createQuery(hql, Borrow.class);
        query.setParameter("param", copy);
        query.setMaxResults(1);
        return query.list();
    }


    public List<Borrow> findByDate(String param, LocalDateTime value) {
        Transaction transaction = session.beginTransaction();
        String hql = String.format("from Borrow where DATE(%s) = DATE(:param)", param);
        Query<Borrow> query = session.createQuery(hql, Borrow.class);
        query.setParameter("param", value);
        return query.list();
    }
}
