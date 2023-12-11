package com.example.services;

import com.example.dao.BorrowDAO;
import com.example.models.Borrow;

import java.util.List;

public class BorrowService {
    BorrowDAO borrowDAO = new BorrowDAO();

    public Borrow findById(final Long id) {
        return borrowDAO.findById(id);
    }

    public void save(Borrow borrow) {
        borrowDAO.save(borrow);
    }

    public void update(Borrow borrow) {
        borrowDAO.update(borrow);
    }

    public List<Borrow> findAll() {
        return borrowDAO.findAll();
    }
}
