package com.example.services;

import com.example.dao.PublisherDAO;
import com.example.models.Publisher;

import java.util.List;

public class PublisherService {
    PublisherDAO publisherDAO = new PublisherDAO();

    public Publisher findByID(final Long id) {
        return publisherDAO.findById(id);
    }

    public void save(Publisher publisher) {
        publisherDAO.save(publisher);
    }

    public void update(Publisher publisher) {
        publisherDAO.update(publisher);
    }

    public List<Publisher> findAll() {
        return publisherDAO.findAll();
    }
}
