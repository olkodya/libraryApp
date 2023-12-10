package com.example.services;

import com.example.dao.ThemeDAO;
import com.example.models.Theme;

public class ThemeService {
    ThemeDAO themeDAO = new ThemeDAO();

    public Theme findTheme(final int id) {
        return themeDAO.findById(id);
    }
}
