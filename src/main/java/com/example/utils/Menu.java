package com.example.utils;

import com.example.services.*;

public class Menu {

    private final AuthorService authorService = new AuthorService();
    private final BookService bookService = new BookService();
    private final BorrowService borrowService = new BorrowService();
    private final CityService cityService = new CityService();
    private final CopyService copyService = new CopyService();
    private final PublisherService publisherService = new PublisherService();
    private final ReaderService readerService = new ReaderService();
    private final ThemeService themeService = new ThemeService();

    public static void printOptions() {
        System.out.println("[1] Books Menu");
        System.out.println("[2] Publishers Menu");
        System.out.println("[3] Cities Menu");
        System.out.println("[4] Copies Menu");
        System.out.println("[5] Authors Menu");
        System.out.println("[6] Readers Menu");
        System.out.println("[7] Themes Menu");
        System.out.println("[8] Borrows Menu");
        System.out.println("[9] Theme Catalog");
        System.out.println("[0] Exit");
    }

    public static void printUpdateBooks() {
//        System.out.println("[1] Upda");
//        System.out.println("[2] Add new book");
//        System.out.println("[3] Delete book");
//        System.out.println("[4] Update book");
//        System.out.println("[0] Exit");
    }


    public static void printMenu() {
        System.out.println("[1] Get all");
        System.out.println("[2] Add");
        System.out.println("[3] Delete");
        System.out.println("[4] Update");
        System.out.println("[5] Find by field");
        System.out.println("[0] Exit");
    }

    public static void printBorrowsMenu() {
        System.out.println("[1] Get all");
        System.out.println("[2] Borrow book");
        System.out.println("[3] Return book");
        System.out.println("[0] Exit");
    }

    public static void printThemeCatalog() {

    }


    public static void run() {


    }
}
