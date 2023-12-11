package com.example.services;

import com.example.dao.CopyDAO;
import com.example.models.Copy;

import java.util.List;

public class CopyService {
    CopyDAO copyDAO = new CopyDAO();

    public Copy findById(final Long id) {
        return copyDAO.findById(id);
    }

    public void save(Copy copy) {
        copyDAO.save(copy);
    }

    public void update(Copy copy) {
        copyDAO.update(copy);
    }

    public List<Copy> findAll() {
        return copyDAO.findAll();
    }
}
