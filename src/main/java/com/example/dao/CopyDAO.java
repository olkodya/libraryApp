package com.example.dao;

import com.example.models.Copy;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class CopyDAO {
    private final Session session;

    public CopyDAO(Session session) {
        this.session = session;

    }
    public Copy findById(Long id) {
        return session.get(Copy.class, id);
    }

    public void save(Copy copy) {
        Transaction transaction = session.beginTransaction();
        session.save(copy);
        transaction.commit();
    }

    public void update(Copy copy) {
        Transaction transaction = session.beginTransaction();
        session.update(copy);
        transaction.commit();
    }

    public void delete(Copy copy) {
        Transaction transaction = session.beginTransaction();
        session.delete(copy);
        transaction.commit();
    }

    public List<Copy> findAll() {
        return (List<Copy>) session.createQuery("From Copy order by id").list();
    }

    public List<Copy> findByParameter(String param, Object value) {
        Transaction transaction = session.beginTransaction();
        String hql = String.format("from Copy where upper(%s) like upper(:param)", param);
        Query<Copy> query = session.createQuery(hql, Copy.class);
        query.setParameter("param", "%" + value + "%");
        return query.list();
    }
}
