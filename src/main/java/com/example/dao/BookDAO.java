package com.example.dao;

import com.example.models.Book;
import org.hibernate.Session;
import org.hibernate.Transaction;

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
        return session.createQuery("From Book").list();
    }
}
