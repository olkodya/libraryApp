package com.example.dao;

import com.example.models.Theme;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class ThemeDAO {

    private final Session session;

    public ThemeDAO(Session session) {
        this.session = session;

    }
    public Theme findById(Long id) {
        return session.get(Theme.class, id);
    }

    public void save(Theme theme) {
        Transaction transaction = session.beginTransaction();
        session.save(theme);
        transaction.commit();
    }

    public void update(Theme theme) {
        Transaction transaction = session.beginTransaction();
        session.update(theme);
        transaction.commit();
    }

    public void delete(Theme theme) {
        Transaction transaction = session.beginTransaction();
        session.delete(theme);
        transaction.commit();
    }

    public List<Theme> findAll() {
        return (List<Theme>) session.createQuery("From Theme order by id").list();
    }

    public List<Theme> findByParameter(String param, Object value) {
        Transaction transaction = session.beginTransaction();
        String hql = String.format("from Theme where upper(%s) like upper(:param)", param);
        Query<Theme> query = session.createQuery(hql, Theme.class);
        query.setParameter("param", "%" + value + "%");
        return query.list();
    }

}
