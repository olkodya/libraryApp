package com.example.dao;

import com.example.models.Book;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.math.BigDecimal;
import java.util.List;

public class BookDAO {
    private final Session session;

    public BookDAO(Session session) {
        this.session = session;

    }

    public Book findById(Long id) {
        return session.get(Book.class, id);
    }

    public void save(Book book) {
        Transaction transaction = session.beginTransaction();
        session.save(book);
        transaction.commit();
    }

    public void update(Book book) {
        Transaction transaction = session.beginTransaction();
        //book.setAuthors(null);
        session.update(book);
        transaction.commit();
    }

    public void delete(Book book) {
        Transaction transaction = session.beginTransaction();
        session.delete(book);
        transaction.commit();
    }

    public List<Book> findAll() {
        return session.createQuery("From Book order by id").list();
    }

    public List<Book> findByParameter(String param, Object value) {
        Transaction transaction = session.beginTransaction();
        String hql;
        Query<Book> query;
        if (!(value instanceof Integer || value instanceof BigDecimal)) {
            hql = String.format("from Book where upper(%s) like upper(:param)", param);
            query = session.createQuery(hql, Book.class);
            query.setParameter("param", "%" + value + "%");
        } else {
            hql = String.format("from Book where %s = :param", param);
            query = session.createQuery(hql, Book.class);
            query.setParameter("param", value);

        }
        return query.list();
    }

    public List<Book> findByAuthor(String value) {
        Transaction transaction = session.beginTransaction();
        String hql = "select b from Book b join b.authors a where upper(a.name) like upper(:param)";
        Query<Book> query = session.createQuery(hql, Book.class);
        query.setParameter("param", "%" + value + "%");
        return query.list();
    }

}
