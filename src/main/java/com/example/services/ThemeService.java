package com.example.services;

import com.example.dao.ThemeDAO;
import com.example.models.Theme;

import java.util.List;

public class ThemeService {
    ThemeDAO themeDAO = new ThemeDAO();

    public Theme findById(final Long id) {
        return themeDAO.findById(id);
    }

    public void save(Theme theme) {
        themeDAO.save(theme);
    }

    public void update(Theme theme) {
        themeDAO.update(theme);
    }

    public List<Theme> findAll() {
        return themeDAO.findAll();
    }


}
