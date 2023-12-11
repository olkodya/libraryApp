package com.example;

import com.example.models.Publisher;
import com.example.models.Theme;
import com.example.services.CityService;
import com.example.services.PublisherService;
import com.example.services.ThemeService;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        ThemeService themeService = new ThemeService();
        Theme theme = new Theme("LALAAA");
        themeService.save(theme);
        List<Theme> themes = themeService.findAll();
        for (Theme value : themes) {
            System.out.println(value.getId() + " " + value.getName());
        }

        System.out.println(themeService.findById(theme.getId()));
        CityService cityService = new CityService();
        PublisherService publisherService = new PublisherService();
        Publisher publisher = publisherService.findByID(8L);
        System.out.println(publisher.getCity().getName());

    }
}