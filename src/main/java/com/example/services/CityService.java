package com.example.services;

import com.example.dao.CityDAO;
import com.example.models.City;

import java.util.List;

public class CityService {
    CityDAO cityDAO = new CityDAO();

    public City findByID(final Long id) {
        return cityDAO.findById(id);
    }

    public void save(City city) {
        cityDAO.save(city);
    }

    public void update(City city) {
        cityDAO.update(city);
    }

    public void delete(City city) {
        cityDAO.delete(city);
    }

    public List<City> findAll() {
        return cityDAO.findAll();
    }
}
