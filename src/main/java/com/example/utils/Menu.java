package com.example.utils;

import com.example.models.Book;
import com.example.models.City;
import com.example.models.Reader;
import com.example.services.*;

import java.util.List;
import java.util.Scanner;

public class Menu {

    private static final AuthorService authorService = new AuthorService();
    private static final BookService bookService = new BookService();
    private static final BorrowService borrowService = new BorrowService();
    private static final CityService cityService = new CityService();
    private static final CopyService copyService = new CopyService();
    private static final PublisherService publisherService = new PublisherService();
    private static final ReaderService readerService = new ReaderService();
    private static final ThemeService themeService = new ThemeService();

    public static void printOptions() {
        System.out.println();
        System.out.println("***Main menu***");
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
        System.out.println("[1] Change isbn");
        System.out.println("[2] Change the name of book");
        System.out.println("[3] Add author to book");
        System.out.println("[4] Delete author from book");
        System.out.println("[5] Change publisher");
        System.out.println("[5] Change publish year");
        System.out.println("[5] Change number of pages");
        System.out.println("[5] Change price");
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

    public static void cityMenu() {
        Scanner scanner = new Scanner(System.in);
        Scanner ints = new Scanner(System.in);
        while (true) {
            List<City> cities;
            City city;
            int choice;
            String name;
            printMenu();
            int option = ints.nextInt();
            switch (option) {
                case 1:
                    System.out.println("Get all cities");
                    cities = cityService.findAll();
                    for (int i = 0; i < cities.size(); i++) {
                        System.out.println((i + 1) + " " + cities.get(i).getName());
                    }
                    break;
                case 2:
                    System.out.println("Add city");
                    System.out.println("Enter city name");
                    name = scanner.nextLine();
                    city = new City(name);
                    cityService.save(city);
                    break;
                case 3:
                    System.out.println("Delete city");
                    cities = cityService.findAll();
                    System.out.println("Choose the city from 1 to" + cities.size());
                    for (int i = 0; i < cities.size(); i++) {
                        System.out.println((i + 1) + " " + cities.get(i).getName());
                    }
                    choice = ints.nextInt();
                    city = cities.get(choice - 1);
                    cityService.delete(city);
                    break;
                //cityService.
                case 4:
                    System.out.println("Update city");
                    cities = cityService.findAll();
                    System.out.println("Choose the city from 1 to " + cities.size());
                    for (int i = 0; i < cities.size(); i++) {
                        System.out.println((i + 1) + " " + cities.get(i).getName());
                    }
                    choice = ints.nextInt();
                    city = cities.get(choice - 1);
                    System.out.println("Enter the name of the city");
                    name = scanner.nextLine();
                    city.setName(name);
                    cityService.update(city);
                    break;
                case 5:
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }

        }

    }


    public static void updateMenu() {

    }


    public static void bookMenu() {
        Scanner scanner = new Scanner(System.in);
        Scanner ints = new Scanner(System.in);
        while (true) {
            List<Book> books;
            Book book;
            int choice;
            String name;
            printMenu();
            int option = ints.nextInt();
            switch (option) {
                case 1:
                    System.out.println("Get all cities");
                    books = bookService.findAll();
                    for (int i = 0; i < books.size(); i++) {
                        // System.out.println(i + " " + books.get(i).());
                    }
                    break;
                case 2:

//                    System.out.println("Add city");
//                    System.out.println("Enter city name");
//                    name = scanner.nextLine();
//                    city = new City(name);
//                    cityService.save(city);
//                    break;
                case 3:
//                    System.out.println("Delete city");
//                    cities = cityService.findAll();
//                    System.out.println("Choose the city from 1 to"+ cities.size());
//                    for (int i = 0; i < cities.size(); i++) {
//                        System.out.println((i + 1) + " " + cities.get(i).getName());
//                    }
//                    choice = ints.nextInt();
//                    city = cities.get(choice - 1);
//                    cityService.delete(city);
//                    break;
                    //cityService.
                case 4:
//                    System.out.println("Update city");
//                    cities = cityService.findAll();
//                    System.out.println("Choose the city from 1 to "+ cities.size());
//                    for (int i = 0; i < cities.size(); i++) {
//                        System.out.println((i + 1) + " " + cities.get(i).getName());
//                    }
//                    choice = ints.nextInt();
//                    city = cities.get(choice - 1);
//                    System.out.println("Enter the name of the city");
//                    name = scanner.nextLine();
//                    city.setName(name);
//                    cityService.update(city);
                    break;
                case 5:
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }

        }

    }


    public static void readerMenu() {
        Scanner scanner = new Scanner(System.in);
        Scanner ints = new Scanner(System.in);
        while (true) {
            List<Reader> readers;
            Reader reader;
            int choice;
            String name;
            printMenu();
            int option = ints.nextInt();
            switch (option) {
                case 1:
                    System.out.println("Get all cities");
                    readers = readerService.findAll();
                    for (int i = 0; i < readers.size(); i++) {
                        System.out.println(i + " " + readers.get(i).getCardNum() + " " + readers.get(i).getFirstName());
                    }
                    break;
                case 2:
//                    System.out.println("Add city");
//                    System.out.println("Enter city name");
//                    name = scanner.nextLine();
//                    city = new City(name);
//                    cityService.save(city);
//                    break;
                case 3:
//                    System.out.println("Delete city");
//                    cities = cityService.findAll();
//                    System.out.println("Choose the city from 1 to"+ cities.size());
//                    for (int i = 0; i < cities.size(); i++) {
//                        System.out.println((i + 1) + " " + cities.get(i).getName());
//                    }
//                    choice = ints.nextInt();
//                    city = cities.get(choice - 1);
//                    cityService.delete(city);
//                    break;
                    //cityService.
                case 4:
//                    System.out.println("Update city");
//                    cities = cityService.findAll();
//                    System.out.println("Choose the city from 1 to "+ cities.size());
//                    for (int i = 0; i < cities.size(); i++) {
//                        System.out.println((i + 1) + " " + cities.get(i).getName());
//                    }
//                    choice = ints.nextInt();
//                    city = cities.get(choice - 1);
//                    System.out.println("Enter the name of the city");
//                    name = scanner.nextLine();
//                    city.setName(name);
//                    cityService.update(city);
                    break;
                case 5:
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }

        }

    }


    public static void run() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            printOptions();
            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    bookMenu();
                    break;
                case 2:
                    break;
                case 3:
                    cityMenu();
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    readerMenu();
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 9:
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid option. Please, try again.");
            }
        }
    }
}
