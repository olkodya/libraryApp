package com.example.dao;

import com.example.models.Reader;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.time.LocalDate;
import java.util.List;

public class ReaderDAO {

    private final Session session;

    public ReaderDAO(Session session) {
        this.session = session;

    }
    public Reader findById(Long id) {
        return session.get(Reader.class, id);
    }

    public void save(Reader reader) {
        Transaction transaction = session.beginTransaction();
        session.save(reader);
        transaction.commit();
    }

    public void update(Reader reader) {
        Transaction transaction = session.beginTransaction();
        reader.setBorrows(null);
        session.update(reader);
        transaction.commit();
    }

    public void delete(Reader reader) {
        reader.setBorrows(null);
        Transaction transaction = session.beginTransaction();
        session.delete(reader);
        transaction.commit();
    }

    public List<Reader> findAll() {
        return (List<Reader>) session.createQuery("From Reader order by id").list();
    }

    public List<Reader> findByParameter(String param, Object value) {
        Transaction transaction = session.beginTransaction();
        String hql = String.format("from Reader where upper(%s) like upper(:param)", param);
        Query<Reader> query = session.createQuery(hql, Reader.class);
        query.setParameter("param", "%" + value + "%");
        return query.list();
    }

    public List<Reader> findByDate(String param, LocalDate value) {
        Transaction transaction = session.beginTransaction();
        String hql = String.format("from Reader where DATE(%s) = DATE(:param)", param);
        Query<Reader> query = session.createQuery(hql, Reader.class);
        query.setParameter("param", value);
        return query.list();
    }

}
