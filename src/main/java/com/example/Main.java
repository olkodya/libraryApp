package com.example;

import com.example.models.Borrow;
import com.example.models.Publisher;
import com.example.models.Reader;
import com.example.models.Theme;
import com.example.services.*;
import com.example.utils.Menu;

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

        //Menu.run();
        ReaderService readerService = new ReaderService();

        Reader reader = new Reader();
        Borrow borrow = new Borrow();
        Reader reader1 = readerService.findById(1L);
//        borrow.setReader(reader1);
        BorrowService borrowService = new BorrowService();
        borrow = borrowService.findById(2L);

//        borrowService.save(borrow);
//        System.out.println(borrow.getReader().getFirstName());
//        System.out.println(reader.getBorrows());
        System.out.println(borrow.getReader().getFirstName());

        List<Borrow> borrows = borrowService.findAll();
        for (Borrow value : borrows) {
            System.out.println(value.getReader().getFirstName() + value.getReader().getId());
        }
        List<Reader> readers = readerService.findAll();
        for (Reader value : readers) {
            System.out.println(value.getFirstName() + " " + value.getBorrows());
            for (Borrow br : value.getBorrows())
                System.out.println();
        }

        Menu.run();
    }
}