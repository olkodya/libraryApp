package com.example.services;

import com.example.dao.ReaderDAO;
import com.example.models.Reader;

import java.util.List;

public class ReaderService {

    ReaderDAO readerDAO = new ReaderDAO();

    public Reader findById(final Long id) {
        return readerDAO.findById(id);
    }

    public void save(Reader reader) {
        readerDAO.save(reader);
    }

    public void update(Reader reader) {
        readerDAO.update(reader);
    }

    public List<Reader> findAll() {
        return readerDAO.findAll();
    }
}
