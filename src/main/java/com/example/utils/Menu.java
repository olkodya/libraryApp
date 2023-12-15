package com.example.utils;

import com.example.models.*;
import com.example.services.*;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.NonUniqueObjectException;
import org.hibernate.exception.ConstraintViolationException;

import javax.persistence.PersistenceException;
import java.math.BigDecimal;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
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

    public static void run() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            printOptions();
            int option = getNumber();
            switch (option) {
                case 1:
                    bookMenu();
                    break;
                case 2:
                    publisherMenu();
                    break;
                case 3:
                    cityMenu();
                    break;
                case 4:
                    copyMenu();
                    break;
                case 5:
                    authorMenu();
                    break;
                case 6:
                    readerMenu();
                    break;
                case 7:
                    themeMenu();
                    break;
                case 8:
                    borrowMenu();
                    break;
                case 9:
                    themeCatalog();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid option. Please, try again.");
            }
        }
    }

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

    public static void printThemeCatalogMenu() {
        System.out.println("[1] Get full theme catalog");
        System.out.println("[2] Add book to theme");
        System.out.println("[3] Remove book from theme");
        System.out.println("[0] Exit");
    }

    public static void printBooks(List<Book> books) {
        if (books.isEmpty()) {
            System.out.println("List of books is empty");
            return;
        }
        System.out.format("%4s%50s%15s%30s%15s%10s%10s%7s%30s\n", "№", "Name", "isbn", "Publisher", "Publish year", "Pages", "Price", "CopNum", "Authors");

        for (int i = 0; i < books.size(); i++) {
            System.out.format("%4d%50s%15s%30s%15s%10s%10s%7s", i + 1, books.get(i).getBook_name(), books.get(i).getIsbn(),
                    books.get(i).getPublisher().getName(), books.get(i).getPublishYear(), books.get(i).getPages(), books.get(i).getPrice(), books.get(i).getCopies().size());

            int size = 0;
            if (!(books.get(i).getAuthors() == null || books.get(i).getAuthors().isEmpty()))
                for (Author author : books.get(i).getAuthors()) {
                    if (size == 0) {
                        System.out.format("%30s\n", author.getName());
                    } else {
                        System.out.format("%171s \n", author.getName());
                    }
                    size++;
                }
        }
    }

    public static void printAuthors(List<Author> authors) {
        if (authors.isEmpty()) {
            System.out.println("List of authors is empty");
            return;
        }
        System.out.format("%4s%30s\n", "№", "Name");
        for (int i = 0; i < authors.size(); i++) {
            System.out.format("%4d%30s\n", i + 1, authors.get(i).getName());
        }
    }

    public static void printCities(List<City> cities) {
        if (cities.isEmpty()) {
            System.out.println("List of cities is empty");
            return;
        }
        System.out.format("%4s%30s\n", "№", "Name");
        for (int i = 0; i < cities.size(); i++) {
            System.out.format("%4d%30s\n", i + 1, cities.get(i).getName());
        }
    }

    public static void printCopies(List<Copy> copies) {
        if (copies.isEmpty()) {
            System.out.println("List of copies is empty");
            return;
        }

        System.out.format("%4s%20s%50s%15s%30s\n", "№", "Inventory num", "Book name", "Book isbn", "Authors");
        for (int i = 0; i < copies.size(); i++) {
            System.out.format("%4d%20s%50s%15s", i + 1, copies.get(i).getInventory_num(), copies.get(i).getBook().getBook_name(), copies.get(i).getBook().getIsbn());
            int size = 0;
            for (Author author : copies.get(i).getBook().getAuthors()) {
                if (size == 0) {
                    System.out.format("%30s\n", author.getName());
                } else {
                    System.out.format("%119s \n", author.getName());
                }
                size++;
            }
        }
    }

    public static void printPublishers(List<Publisher> publishers) {
        if (publishers.isEmpty()) {
            System.out.println("List of publishers is empty");
            return;
        }
        System.out.format("%4s%30s%30s\n", "№", "Name", "Place");
        for (int i = 0; i < publishers.size(); i++) {
            System.out.format("%4d%30s%30s\n", i + 1, publishers.get(i).getName(), publishers.get(i).getCity().getName());
        }

    }

    public static void printReaders(List<Reader> readers) {
        if (readers.isEmpty()) {
            System.out.println("List of readers is empty");
            return;
        }
        System.out.format("%4s%15s%30s%30s%30s%30s%15s\n", "№", "Card number", "Last name", "First Name", "Middle name", "Birth date", "Phone number");

        for (int i = 0; i < readers.size(); i++) {
            System.out.format("%4d%15s%30s%30s%30s%30s%15s\n", i + 1, readers.get(i).getCardNum(), readers.get(i).getLastName(), readers.get(i).getFirstName(), readers.get(i).getMiddleName(), readers.get(i).getBirthDate(), readers.get(i).getPhoneNumber());
        }

    }

    public static void printThemes(List<Theme> themes) {
        if (themes.isEmpty()) {
            System.out.println("List of themes is empty");
            return;
        }
        System.out.format("%4s%50s\n", "№", "Name");
        for (int i = 0; i < themes.size(); i++) {
            System.out.format("%4d%50s\n", i + 1, themes.get(i).getName());
        }
    }

    public static void printBorrows(List<Borrow> borrows) {
        if (borrows.isEmpty()) {
            System.out.println("List of borrows is empty");
            return;
        }
        System.out.format("%4s%10s%10s%15s%50s%30s%30s\n", "№", "Reader", "Copy", "isbn", "Book", "Borrow date", "Return date");
        for (int i = 0; i < borrows.size(); i++) {
            System.out.format("%4d%10s%10s%15s%50s%30s%30s\n", i + 1, borrows.get(i).getReader().getCardNum(), borrows.get(i).getCopy().getInventory_num(), borrows.get(i).getCopy().getBook().getIsbn(), borrows.get(i).getCopy().getBook().getBook_name(), borrows.get(i).getBorrowDate(), borrows.get(i).getReturnDate());
        }
    }

    public static void printThemeCatalog(List<Theme> themes) {
        if (themes.isEmpty()) {
            System.out.println("List of themes is empty");
            return;
        }
        for (int i = 0; i < themes.size(); i++) {
            System.out.println((i + 1) + ")");
            int j = 1;
            System.out.println("Theme name: " + themes.get(i).getName());
            for (Book book : themes.get(i).getBooks()) {
                System.out.println("\t" + j + ")");
                System.out.println("\tisbn: " + book.getIsbn());
                System.out.println("\tName: " + book.getBook_name());
                System.out.println("\tAuthors:");
                for (Author author : book.getAuthors()) {
                    System.out.println("\t" + author.getName());
                }
                System.out.println("\tCopies amount: " + book.getCopies().size());
                j++;
            }

        }
    }


    public static int getNumber() {
        Scanner scanner = new Scanner(System.in);
        String input;
        while (true) {
            input = scanner.nextLine();
            if (StringUtils.isNumeric(input))
                break;
            else {
                System.out.println("Your input should contain only digits. Please try again!");
            }
        }
        return Integer.parseInt(input);
    }

    public static int getNumber(int start, int end) {
        Scanner scanner = new Scanner(System.in);
        String input;
        while (true) {
            input = scanner.nextLine();
            if (StringUtils.isNumeric(input) && Integer.parseInt(input) >= start && Integer.parseInt(input) <= end)
                break;
            else {
                System.out.println("Invalid input. Please try again!");
            }
        }
        return Integer.parseInt(input);
    }

    public static void cityMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            List<City> cities;
            City city;
            int choice;
            String name;
            printMenu();
            int option = getNumber();
            switch (option) {
                case 1:
                    System.out.println("Get all cities");
                    cities = cityService.findAll();
                    printCities(cities);
                    break;
                case 2:
                    System.out.println("Add city");
                    System.out.println("Enter city name");
                    name = scanner.nextLine();
                    city = new City(name);
                    try {
                        cityService.save(city);
                    } catch (ConstraintViolationException exception) {
                        System.out.println("City with this name already exists");
                    }
                    break;
                case 3:
                    System.out.println("Delete city");
                    cities = cityService.findAll();
                    System.out.println("Choose the city from 1 to " + cities.size());
                    printCities(cities);
                    choice = getNumber(1, cities.size());
                    city = cities.get(choice - 1);
                    if (city.getPublishers() == null || city.getPublishers().isEmpty())
                        cityService.delete(city);
                    else {
                        System.out.println("There are publishers with this city. It can't be deleted.");
                    }
                    break;
                case 4:
                    System.out.println("Update city");
                    cities = cityService.findAll();
                    System.out.println("Choose the city from 1 to " + cities.size());
                    printCities(cities);
                    choice = getNumber(1, cities.size());
                    city = cities.get(choice - 1);
                    System.out.println("Enter the name of the city");
                    name = scanner.nextLine();
                    try {
                        city.setName(name);
                        cityService.update(city);
                    } catch (PersistenceException exception) {
                        System.out.println("This city already exists");
                    }
                    break;
                case 5:
                    System.out.println("Search city by name");
                    System.out.println("????Enter line to search");
                    String nameS = scanner.nextLine();
                    cities = cityService.findByParameter("name", nameS);
                    System.out.println("Founded cities:");
                    printCities(cities);
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }

        }

    }

    public static void printUpdateBook() {
        System.out.println("[1] Add author to book");
        System.out.println("[2] Remove author from book");
        System.out.println("[3] Update book's isbn");
        System.out.println("[4] Update book's name");
        System.out.println("[5] Update book's publisher");
        System.out.println("[6] Update book's publish year");
        System.out.println("[7] Update book's number of pages");
        System.out.println("[8] Update book's price");
        System.out.println("[0] Exit");
    }


    public static void updateBookMenu(Book book) {
        Scanner scanner = new Scanner(System.in);
        String name, isbn;
        int pages, price, publishYear;
        List<Publisher> publishers;
        List<Author> authors;
        int choice;
        while (true) {
            printUpdateBook();
            int option = getNumber();
            switch (option) {
                case 1:
                    System.out.println("Add author to book");
                    authors = authorService.findAll();
                    printAuthors(authors);
                    System.out.println("Choose author from 1 to " + authors.size());
                    choice = getNumber(1, authors.size());
                    try {
                        if (!book.getAuthors().contains(authors.get(choice - 1))) {
                            book.addAuthor(authors.get(choice - 1));
                            bookService.update(book);
                        } else {
                            System.out.println("This author was already added to the book");
                        }
                    } catch (NonUniqueObjectException exception) {
                        System.out.println("This author was already added to the book");
                    }

                    break;
                case 2:
                    System.out.println("Remove author from book");
                    authors = new ArrayList<>(book.getAuthors());
                    printAuthors(authors);
                    System.out.println("Choose author from 1 to " + authors.size());
                    choice = getNumber(1, authors.size());
                    book.removeAuthor(authors.get(choice - 1));
                    bookService.update(book);
                    break;
                case 3:
                    System.out.println("Update book's isbn");
                    System.out.println("Enter the firstname of reader. ");
                    try {
                        isbn = scanner.nextLine();
                        book.setIsbn(isbn);
                        bookService.update(book);
                        System.out.println("Book was successfully updated");
                    } catch (PersistenceException exception) {
                        System.out.println("Book with this isbn already exists");
                    }
                    break;
                case 4:
                    System.out.println("Update book's name");
                    System.out.println("Enter the name of book");
                    name = scanner.nextLine();
                    book.setBook_name(name);
                    bookService.update(book);
                    System.out.println("Book was successfully updated");

                    break;
                case 5:
                    System.out.println("Update book's publisher date");
                    System.out.println("Enter the name of book");
                    publishers = publisherService.findAll();
                    printPublishers(publishers);
                    System.out.println("Choose publisher from 1 to " + publishers.size());
                    choice = getNumber(1, publishers.size());
                    book.setPublisher(publishers.get(choice - 1));
                    bookService.update(book);
                    System.out.println("Book was successfully updated");
                    break;
                case 6:
                    System.out.println("Update book's publish year");
                    System.out.println("Enter publish year ");
                    publishYear = getNumber();
                    book.setPublishYear(publishYear);
                    bookService.update(book);
                    System.out.println("Book was successfully updated");
                    break;
                case 7:
                    System.out.println("Update book's number of pages");
                    System.out.println("Enter number of pages");
                    pages = getNumber();
                    book.setPages(pages);
                    bookService.update(book);
                    System.out.println("Book was successfully updated");
                    break;
                case 8:
                    System.out.println("Update book's price");
                    System.out.println("Enter price");
                    price = getNumber();
                    book.setPrice(BigDecimal.valueOf(price));
                    bookService.update(book);
                    System.out.println("Book was successfully updated");
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");

            }
        }
    }

    public static void printSearchBook() {
        System.out.println("[1] Search by isbn");
        System.out.println("[2] Search by name");
        System.out.println("[3] Search by publisher");
        System.out.println("[4] Search by publish year");
        System.out.println("[5] Search by number of pages");
        System.out.println("[6] Search by price");
        System.out.println("[7] Search by author");
        System.out.println("[0] Exit");
    }


    public static void searchBookMenu() {
        Scanner scanner = new Scanner(System.in);
        String name, isbn;
        int pages, price, publishYear;
        List<Book> books;
        int choice;
        while (true) {
            printSearchBook();
            int option = getNumber();
            switch (option) {
                case 1:
                    System.out.println("Search by isbn");
                    System.out.println("Enter to search");
                    isbn = scanner.nextLine();
                    books = bookService.findByParameter("isbn", isbn);
                    System.out.println("Founded books");
                    printBooks(books);
                    break;
                case 2:
                    System.out.println("Search by name");
                    System.out.println("Enter to search");
                    name = scanner.nextLine();
                    books = bookService.findByParameter("book_name", name);
                    System.out.println("Founded books");
                    printBooks(books);
                    break;
                case 3:
                    System.out.println("Search by publisher");
                    System.out.println("Enter to search");
                    name = scanner.nextLine();
                    books = bookService.findByParameter("publisher.name", name);
                    System.out.println("Founded books");
                    printBooks(books);
                    break;
                case 4:
                    System.out.println("Search by publish year");
                    System.out.println("Enter to search");
                    publishYear = getNumber();
                    books = bookService.findByParameter("publishYear", publishYear);
                    System.out.println("Founded books");
                    printBooks(books);
                    break;
                case 5:
                    System.out.println("Search by number of pages");
                    System.out.println("Enter to search");
                    pages = getNumber();
                    books = bookService.findByParameter("pages", pages);
                    System.out.println("Founded books");
                    printBooks(books);
                    break;
                case 6:
                    System.out.println("Search by price");
                    System.out.println("Enter to search");
                    price = getNumber();
                    books = bookService.findByParameter("price", BigDecimal.valueOf(price));
                    System.out.println("Founded books");
                    printBooks(books);
                    break;
                case 7:
                    System.out.println("Search by author");
                    System.out.println("Enter to search");
                    name = scanner.nextLine();
                    books = bookService.findByAuthor(name);
                    System.out.println("Founded books");
                    printBooks(books);
                case 0:
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");

            }
        }
    }

    public static void bookMenu() {
        Scanner scanner = new Scanner(System.in);
        Scanner ints = new Scanner(System.in);
        while (true) {
            List<Book> books;
            List<Publisher> publishers;
            List<Author> authors;
            Book book;
            int choice;
            String name, isbn;
            int publishYear, pages, price, copiesAmount;
            printMenu();
            int option = getNumber();
            switch (option) {
                case 1:
                    System.out.println("Get all books");
                    books = bookService.findAll();
                    printBooks(books);
                    break;
                case 2:
                    System.out.println("Add book");
                    publishers = publisherService.findAll();
                    authors = authorService.findAll();
                    if (publishers == null || publishers.isEmpty()) {
                        System.out.println("List of publishers is empty. You can't to add book");
                        break;
                    }

                    if (authors == null || authors.isEmpty()) {
                        System.out.println("List of authors is empty. You can't to add book");
                        break;
                    }
                    book = new Book();
                    System.out.println("Enter isbn");
                    isbn = scanner.nextLine();
                    book.setIsbn(isbn);
                    System.out.println("Enter the name of book");
                    name = scanner.nextLine();
                    book.setBook_name(name);
                    int authNum;
                    System.out.println("Print number of authors(from 1 to 10)");
                    authNum = getNumber(1, 10);
                    if (authNum > authors.size()) {
                        System.out.println("There are not such a number of authors");
                        break;
                    }
                    printAuthors(authors);
                    for (int i = 0; i < authNum; i++) {
                        System.out.println("Choose author from 1 to " + authors.size());
                        choice = getNumber(1, authors.size());
                        if (!book.getAuthors().contains(authors.get(choice - 1))) {
                            book.addAuthor(authors.get(choice - 1));
                        } else {
                            System.out.println("this author was already added");
                            i--;
                        }
                    }
                    printPublishers(publishers);
                    System.out.println("Choose publisher from 1 to " + publishers.size());
                    choice = getNumber(1, publishers.size());
                    book.setPublisher(publishers.get(choice - 1));
                    System.out.println("Enter publish year");
                    publishYear = getNumber();
                    book.setPublishYear(publishYear);
                    System.out.println("Enter number of pages");
                    pages = getNumber();
                    book.setPages(pages);
                    System.out.println("Enter price");
                    price = getNumber();
                    book.setPrice(BigDecimal.valueOf(price));
                    try {
                        bookService.save(book);
                    } catch (ConstraintViolationException | NonUniqueObjectException exception) {
                        System.out.println("Book with this isbn already exists");
                    }
                    break;
                case 3:
                    System.out.println("Delete book");
                    books = bookService.findAll();
                    if (books.isEmpty()) {
                        System.out.println("The list of books is empty. Nothing to delete");
                        break;
                    }
                    printBooks(books);
                    System.out.println("Choose the book from 1 to" + books.size());
                    choice = getNumber(1, books.size());
                    if (!(books.get(choice - 1).getCopies() == null || books.get(choice - 1).getCopies().isEmpty())) {
                        System.out.println("You can't delete the book, because there are copies of this book");
                        break;
                    }

                    if (!(books.get(choice - 1).getAuthors() == null || books.get(choice - 1).getAuthors().isEmpty())) {
                        System.out.println("You can't delete the book, because there are authors of this book");
                        break;
                    }
                    if (!(books.get(choice - 1).getThemes() == null || books.get(choice - 1).getThemes().isEmpty())) {
                        System.out.println("You can't delete the book, because this book is in theme catalog");
                        break;
                    }
                    bookService.delete(books.get(choice - 1));
                    break;
                case 4:
                    System.out.println("Update book");
                    books = bookService.findAll();
                    if (books.isEmpty()) {
                        System.out.println("The list of books is empty. Nothing to update");
                        break;
                    }
                    printBooks(books);
                    System.out.println("Choose the book from 1 to " + books.size());
                    choice = getNumber(1, books.size());
                    book = books.get(choice - 1);
                    updateBookMenu(book);
                    break;
                case 5:
                    searchBookMenu();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }

        }

    }

    public static LocalDate getDate() {
        int year, month, day;
        boolean flag = false;
        LocalDate date = null;
        Scanner scanner = new Scanner(System.in);
        LocalDate now = LocalDate.now();
        do {
            try {
                flag = false;
                System.out.println("Enter year");
                year = getNumber();
                if (year > now.getYear() || year < (now.getYear() - 150))
                    throw (new DateTimeException("Invalid year"));

                System.out.println("Enter month");
                month = getNumber();
                System.out.println("Enter day");
                day = getNumber();
                date = LocalDate.of(year, month, day);
            } catch (DateTimeException ex) {
                System.out.println("Invalid date. Try again");
                flag = true;
            }
        } while (flag);

        return date;
    }


    public static void printUpdateReader() {
        System.out.println("[1] Update reader's card number");
        System.out.println("[2] Update reader's lastname");
        System.out.println("[3] Update reader's firstname");
        System.out.println("[4] Update reader's middlename");
        System.out.println("[5] Update reader's birth date");
        System.out.println("[6] Update reader's phone number");
        System.out.println("[0] Exit");
    }


    public static void updateReaderMenu(Reader reader) {
        Scanner scanner = new Scanner(System.in);
        String name, phoneNumber, cardNum;
        List<City> cities;
        LocalDate date;
        while (true) {
            printUpdateReader();
            int option = getNumber();
            switch (option) {
                case 1:
                    System.out.println("Update reader's card number");
                    System.out.println("Enter the card number of reader. ");
                    try {
                        cardNum = scanner.nextLine();
                        reader.setCardNum(cardNum);
                        readerService.update(reader);
                        System.out.println("Reader was successfully updated");
                    } catch (PersistenceException exception) {
                        System.out.println("This reader already exists");
                    }
                    break;
                case 2:
                    System.out.println("Update reader's lastname");
                    System.out.println("Enter the lastname of reader. ");
                    try {
                        name = scanner.nextLine();
                        reader.setLastName(name);
                        readerService.update(reader);
                        System.out.println("Reader was successfully updated");
                    } catch (PersistenceException exception) {
                        System.out.println("This reader already exists");
                    }
                    break;
                case 3:
                    System.out.println("Update reader's firstname");
                    System.out.println("Enter the firstname of reader. ");
                    try {
                        name = scanner.nextLine();
                        reader.setFirstName(name);
                        readerService.update(reader);
                        System.out.println("Reader was successfully updated");
                    } catch (PersistenceException exception) {
                        System.out.println("This reader already exists");
                    }
                    break;
                case 4:
                    System.out.println("Update reader's middlename");
                    System.out.println("Enter the middlename of reader. ");
                    try {
                        name = scanner.nextLine();
                        reader.setMiddleName(name);
                        readerService.update(reader);
                        System.out.println("Reader was successfully updated");
                    } catch (PersistenceException exception) {
                        System.out.println("This reader already exists");
                    }
                    break;
                case 5:
                    System.out.println("Update reader's birth date");
                    System.out.println("Birth date");
                    try {
                        date = getDate();
                        reader.setBirthDate(date);
                        readerService.update(reader);
                        System.out.println("Reader was successfully updated");
                    } catch (PersistenceException exception) {
                        System.out.println("This reader already exists");
                    }
                    break;
                case 6:
                    System.out.println("Update reader's phone number");
                    System.out.println("Enter the phone number of reader. ");
                    try {
                        phoneNumber = scanner.nextLine();
                        reader.setPhoneNumber(phoneNumber);
                        readerService.update(reader);
                        System.out.println("Reader was successfully updated");
                    } catch (PersistenceException exception) {
                        System.out.println("This reader already exists");
                    }
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");

            }
        }
    }


    public static void printSearchReader() {
        System.out.println("[1] Search reader by card number");
        System.out.println("[2] Search reader by lastname");
        System.out.println("[3] Search reader by firstname");
        System.out.println("[4] Search reader by middlename");
        System.out.println("[5] Search reader by birth date");
        System.out.println("[6] Search reader by phone number");
        System.out.println("[0] Exit");
    }


    public static void searchReaderMenu() {

        String name, phoneNumber, cardNum;
        List<Reader> readers;
        LocalDate date;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            printSearchReader();
            int option = getNumber();
            switch (option) {
                case 1:
                    System.out.println("Search reader by card number");
                    System.out.println("Enter the card number of reader. ");
                    cardNum = scanner.nextLine();
                    readers = readerService.findByParameter("cardNum", cardNum);
                    System.out.println("Founded readers: ");
                    printReaders(readers);
                    break;
                case 2:
                    System.out.println("Search reader by lastname");
                    System.out.println("Enter to search");
                    name = scanner.nextLine();
                    readers = readerService.findByParameter("lastName", name);
                    System.out.println("Founded readers: ");
                    printReaders(readers);
                    break;
                case 3:
                    System.out.println("Search reader by firstname");
                    System.out.println("Enter to search");
                    name = scanner.nextLine();
                    readers = readerService.findByParameter("firstName", name);
                    System.out.println("Founded readers: ");
                    printReaders(readers);
                    break;
                case 4:
                    System.out.println("Search reader by middlename");
                    System.out.println("Enter to search");
                    name = scanner.nextLine();
                    readers = readerService.findByParameter("middleName", name);
                    System.out.println("Founded readers: ");
                    printReaders(readers);
                    break;
                case 5:
                    System.out.println("Search reader by birth date");
                    System.out.println("Enter to search");
                    date = getDate();
                    readers = readerService.findByParameter("birthDate", date);
                    System.out.println("Founded readers: ");
                    printReaders(readers);
                    break;
                case 6:
                    System.out.println("Search reader by phone number");
                    System.out.println("Enter to search ");
                    phoneNumber = scanner.nextLine();
                    readers = readerService.findByParameter("phoneNumber", phoneNumber);
                    System.out.println("Founded readers: ");
                    printReaders(readers);
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
            String cardNum, lastName, firstName, middleName, phoneNumber;
            LocalDate date;
            printMenu();
            int option = getNumber();
            switch (option) {
                case 1:
                    System.out.println("Get all readers");
                    readers = readerService.findAll();
                    printReaders(readers);
                    break;
                case 2:
                    System.out.println("Add reader");
                    System.out.println("Enter reader card number");
                    cardNum = scanner.nextLine();
                    System.out.println("Enter Last name");
                    lastName = scanner.nextLine();
                    System.out.println("Enter First name");
                    firstName = scanner.nextLine();
                    System.out.println("Enter Middle name");
                    middleName = scanner.nextLine();
                    System.out.println("Birth date");
                    date = getDate();
                    System.out.println(" Birth date: " + date);
                    System.out.println("Enter phone number");
                    phoneNumber = scanner.nextLine();
                    reader = new Reader(cardNum, lastName, firstName, middleName, date, phoneNumber);
                    try {
                        readerService.save(reader);
                    } catch (ConstraintViolationException exception) {
                        System.out.println("Reader with this card number already exists");
                    }
                    break;
                case 3:
                    System.out.println("Delete reader");
                    readers = readerService.findAll();
                    if (readers.isEmpty()) {
                        System.out.println("List of readers is empty. Nothing to delete");
                        break;
                    }
                    printReaders(readers);
                    System.out.println("Choose the reader from 1 to " + readers.size());
                    choice = getNumber(1, readers.size());
                    reader = readers.get(choice - 1);
                    if (reader.getBorrows() == null || reader.getBorrows().isEmpty())
                        readerService.delete(reader);
                    else
                        System.out.println("Thе reader has some borrows. Can't be deleted.");
                    break;
                case 4:
                    System.out.println("Update reader");
                    readers = readerService.findAll();
                    if (readers.isEmpty()) {
                        System.out.println("The list of readers is empty. Nothing to update. ");
                    }
                    printReaders(readers);
                    System.out.println("Choose the reader from 1 to " + readers.size());
                    choice = getNumber(1, readers.size());
                    reader = readers.get(choice - 1);
                    updateReaderMenu(reader);
                    break;
                case 5:
                    System.out.println("Search reader menu");
                    searchReaderMenu();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }

        }

    }

    public static void printUpdatePublisher() {
        System.out.println("[1] Update publisher's name");
        System.out.println("[2] Update publisher's city");
        System.out.println("[0] Exit");
    }


    public static void updatePublisherMenu(Publisher publisher) {
        Scanner scanner = new Scanner(System.in);
        String name;
        List<City> cities;
        int choice;
        while (true) {
            printUpdatePublisher();
            int option = getNumber();
            switch (option) {
                case 1:
                    System.out.println("Update publisher's name");
                    System.out.println("Enter the name of publisher. ");
                    try {
                        name = scanner.nextLine();
                        publisher.setName(name);
                        publisherService.update(publisher);
                        System.out.println("Publisher was successfully updated");
                    } catch (PersistenceException exception) {
                        System.out.println("This publisher already exists");
                    }
                    break;
                case 2:
                    System.out.println("Update publisher's city");
                    cities = cityService.findAll();
                    printCities(cities);
                    System.out.println("Choose the city of publisher from 1 to " + cities.size());
                    choice = getNumber(1, cities.size());
                    try {
                        publisher.setCity(cities.get(choice - 1));
                        publisherService.update(publisher);
                        System.out.println("Publisher was successfully updated");
                    } catch (PersistenceException exception) {
                        System.out.println("This publisher already exists");
                    }
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");

            }
        }
    }

    public static void searchPublisherPrint() {
        System.out.println("[1] Search by name");
        System.out.println("[2] Search by place");
        System.out.println("[0] Exit");
    }


    public static void searchPublisher() {
        Scanner scanner = new Scanner(System.in);
        String name;

        List<Publisher> publishers;
        int choice;
        String searchString;
        while (true) {
            searchPublisherPrint();
            int option = getNumber();
            switch (option) {
                case 1:
                    System.out.println("Search by name");
                    System.out.println("Enter to search");
                    searchString = scanner.nextLine();
                    publishers = publisherService.findByParameter("name", searchString);
                    System.out.println("Founded publishers: ");
                    printPublishers(publishers);
                    break;
                case 2:
                    System.out.println("Search by name");
                    System.out.println("Enter to search");
                    searchString = scanner.nextLine();
                    publishers = publisherService.findByParameter("city.name", searchString);
                    System.out.println("Founded publishers: ");
                    printPublishers(publishers);
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");

            }
        }
    }


    public static void publisherMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            List<Publisher> publishers;
            List<City> cities;
            City city;
            Publisher publisher;
            int choice;
            String name;
            printMenu();
            int option = getNumber();
            switch (option) {
                case 1:
                    System.out.println("Get all publishers");
                    publishers = publisherService.findAll();
                    printPublishers(publishers);
                    break;
                case 2:
                    System.out.println("Add publisher");
                    cities = cityService.findAll();
                    if (cities.isEmpty()) {
                        System.out.println("Firstly you need to add at least one city");
                        break;
                    }
                    System.out.println("Enter the name of publisher");
                    name = scanner.nextLine();
                    printCities(cities);
                    System.out.println("Choose the city from 1 to " + cities.size());
                    choice = getNumber(1, cities.size());
                    city = cities.get(choice - 1);
                    publisher = new Publisher();
                    publisher.setName(name);
                    publisher.setCity(city);
                    try {
                        publisherService.save(publisher);
                    } catch (ConstraintViolationException exception) {
                        System.out.println("This publisher already exists");
                    }
                    break;
                case 3:
                    System.out.println("Delete publisher");
                    publishers = publisherService.findAll();
                    if (publishers.isEmpty()) {
                        System.out.println("List of publishers is empty. Nothing to delete.");
                        break;
                    }
                    printPublishers(publishers);
                    System.out.println("Choose publisher from 1 to " + publishers.size());
                    choice = getNumber(1, publishers.size());
                    publisher = publishers.get(choice - 1);
                    if (publisher.getBooks() == null || publisher.getBooks().isEmpty()) {
                        publisherService.delete(publisher);
                    } else {
                        System.out.println("There are books of this publisher. It can't be deleted.");
                    }
                    break;
                case 4:
                    System.out.println("Update publisher");
                    publishers = publisherService.findAll();
                    if (publishers.isEmpty()) {
                        System.out.println("List of publishers is empty. Nothing to update.");
                        break;
                    }
                    printPublishers(publishers);
                    System.out.println("Choose publisher to update from 1 to " + publishers.size());
                    choice = getNumber(1, publishers.size());
                    publisher = publishers.get(choice - 1);
                    try {
                        updatePublisherMenu(publisher);
                    } catch (ConstraintViolationException exception) {
                        System.out.println("This publisher already exists");
                    }
                    break;
                case 5:
                    searchPublisher();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }

        }

    }

    public static void printUpdateCopy() {
        System.out.println("[1] Update copy's inventory number");
        System.out.println("[2] Change copy's book");
        System.out.println("[0] Exit");
    }


    public static void updateCopyMenu(Copy copy) {
        Scanner scanner = new Scanner(System.in);
        String invNum;
        List<Book> books;
        Book book;
        int choice;
        while (true) {
            printUpdatePublisher();
            int option = getNumber();
            switch (option) {
                case 1:
                    System.out.println("Update copy's inventory num");
                    System.out.println("Enter the name of publisher. ");
                    try {
                        invNum = scanner.nextLine();
                        copy.setInventory_num(invNum);
                        copyService.update(copy);
                        System.out.println("Copy was successfully updated");
                    } catch (PersistenceException exception) {
                        System.out.println("This publisher already exists");
                    }
                    break;
                case 2:
                    System.out.println("Update copy's book");
                    books = bookService.findAll();
                    printBooks(books);
                    Book book2;
                    System.out.println("Enter the book from 1 to " + books.size());
                    choice = getNumber(1, books.size());
                    book2 = books.get(choice - 1);
                    book = copy.getBook();
                    copy.setBook(book2);
                    book2.getCopies().add(copy);
                    book.getCopies().remove(copy);
                    copyService.update(copy);
                    System.out.println("Copy was successfully updated");

                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");

            }
        }
    }

    public static void searchCopyPrint() {
        System.out.println("[1] Search by inventory num");
        System.out.println("[2] Search by book name");
        System.out.println("[3] Search by book isbn");
        System.out.println("[0] Exit");
    }


    public static void searchCopy() {
        Scanner scanner = new Scanner(System.in);
        String name;

        List<Copy> copies;
        int choice;
        String searchString;
        while (true) {
            searchCopyPrint();
            int option = getNumber();
            switch (option) {
                case 1:
                    System.out.println("Search by inventory num");
                    System.out.println("Enter to search");
                    searchString = scanner.nextLine();
                    copies = copyService.findByParameter("inventory_num", searchString);
                    System.out.println("Founded publishers: ");
                    printCopies(copies);
                    break;
                case 2:
                    System.out.println("Search by book name");
                    System.out.println("Enter to search");
                    searchString = scanner.nextLine();
                    copies = copyService.findByParameter("book.book_name", searchString);
                    System.out.println("Founded publishers: ");
                    printCopies(copies);
                    break;
                case 3:
                    System.out.println("Search by book isbn");
                    System.out.println("Enter to search");
                    searchString = scanner.nextLine();
                    copies = copyService.findByParameter("book.isbn", searchString);
                    System.out.println("Founded publishers: ");
                    printCopies(copies);
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");

            }
        }
    }

    public static void copyMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            List<Copy> copies;
            List<Book> books;
            Copy copy;
            int choice;
            String inventoryNum;
            printMenu();
            int option = getNumber();
            switch (option) {
                case 1:
                    System.out.println("Get all cities");
                    copies = copyService.findAll();
                    printCopies(copies);
                    break;
                case 2:
                    System.out.println("Add copy");
                    books = bookService.findAll();
                    if (books == null || books.isEmpty()) {
                        System.out.println("There is no books to add copies");
                        break;
                    }
                    printBooks(books);
                    System.out.println("Choose book to add copy from 1 to " + books.size());
                    choice = getNumber(1, books.size());
                    copy = new Copy();
                    copy.setBook(books.get(choice - 1));
                    books.get(choice - 1).getCopies().add(copy);
                    System.out.println("Enter copy inventory number");
                    inventoryNum = scanner.nextLine();
                    copy.setInventory_num(inventoryNum);
                    try {
                        copyService.save(copy);
                    } catch (ConstraintViolationException exception) {
                        System.out.println("The copy with this inventory number already exists");
                    }
                    break;
                case 3:
                    System.out.println("Delete copy");
                    copies = copyService.findAll();
                    if (copies == null || copies.isEmpty()) {
                        System.out.println("List of copies is empty. Nothing to delete");
                        break;
                    }
                    printCopies(copies);
                    System.out.println("Choose the copy from 1 to " + copies.size());
                    choice = getNumber();
                    copy = copies.get(choice - 1);
                    Book book = copy.getBook();
                    copyService.delete(copy);
                    bookService.update(book);
                    System.out.println("Copy was successfully removed");
                    break;
                case 4:
                    System.out.println("Update copy");
                    copies = copyService.findAll();
                    if (copies == null || copies.isEmpty()) {
                        System.out.println("List of copies is empty. Nothing to delete");
                        break;
                    }
                    printCopies(copies);
                    System.out.println("Choose the copy from 1 to " + copies.size());
                    choice = getNumber(1, copies.size());
                    copy = copies.get(choice - 1);
                    updateCopyMenu(copy);
                    break;
                case 5:
                    searchCopy();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }

        }

    }

    public static void themeMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            List<Theme> themes;
            Theme theme;
            int choice;
            String name;
            printMenu();
            int option = getNumber();
            switch (option) {
                case 1:
                    System.out.println("Get all themes");
                    themes = themeService.findAll();
                    printThemes(themes);
                    break;
                case 2:
                    System.out.println("Add theme");
                    System.out.println("Enter theme name");
                    name = scanner.nextLine();
                    theme = new Theme(name);
                    try {
                        themeService.save(theme);
                    } catch (ConstraintViolationException exception) {
                        System.out.println("Theme with this name already exists");
                    }
                    break;
                case 3:
                    System.out.println("Delete theme");
                    themes = themeService.findAll();
                    if (!themes.isEmpty()) {
                        System.out.println("Choose the theme from 1 to " + themes.size());
                        printThemes(themes);
                        choice = getNumber(1, themes.size());
                        if (themes.get(choice - 1).getBooks() == null || themes.get(choice - 1).getBooks().isEmpty()) {
                            themeService.delete(themes.get(choice - 1));
                            System.out.println("Theme was successfully removed");
                        } else {
                            System.out.println("There are books of this theme. It can't be deleted. ");
                        }
                    } else
                        System.out.println("List of themes is empty. Nothing to delete!");
                    break;
                case 4:
                    System.out.println("Edit theme");
                    themes = themeService.findAll();
                    if (!themes.isEmpty()) {
                        printThemes(themes);
                        System.out.println("Choose the theme from 1 to " + themes.size());
                        choice = getNumber(1, themes.size());
                        theme = themes.get(choice - 1);
                        System.out.println("Enter the name of the theme");
                        name = scanner.nextLine();
                        theme.setName(name);
                        themeService.update(theme);
                    } else
                        System.out.println("List of themes is empty. Nothing to update!");
                    break;
                case 5:
                    System.out.println("Search theme by name");
                    System.out.println("????Enter line to search");
                    String nameS = scanner.nextLine();
                    themes = themeService.findByParameter("name", nameS);
                    System.out.println("Founded themes:");
                    printThemes(themes);
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }

        }

    }


    public static void authorMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            List<Author> authors;
            Author author;
            int choice;
            String name;
            printMenu();
            int option = getNumber();
            switch (option) {
                case 1:
                    System.out.println("Get all authors");
                    authors = authorService.findAll();
                    printAuthors(authors);
                    break;
                case 2:
                    System.out.println("Add author");
                    System.out.println("Enter the name of author");
                    name = scanner.nextLine();
                    author = new Author(name);
                    try {
                        authorService.save(author);
                    } catch (ConstraintViolationException exception) {
                        System.out.println("Author with this name already exists");
                    }
                    break;
                case 3:
                    System.out.println("Delete author");
                    authors = authorService.findAll();
                    printAuthors(authors);
                    System.out.println("Choose the author from 1 to " + authors.size());
                    choice = getNumber(1, authors.size());
                    if (authors.get(choice - 1).getBooks() == null || authors.get(choice - 1).getBooks().isEmpty())
                        authorService.delete(authors.get(choice - 1));
                    else {
                        System.out.println("There are books of this author. Can't be deleted.");
                    }
                    break;
                case 4:
                    System.out.println("Update author's name");
                    authors = authorService.findAll();
                    printAuthors(authors);
                    System.out.println("Choose the author from 1 to " + authors.size());
                    choice = getNumber(1, authors.size());
                    author = authors.get(choice - 1);
                    System.out.println("Enter the name of author");
                    name = scanner.nextLine();
                    author.setName(name);
                    authorService.update(author);
                    break;
                case 5:
                    System.out.println("Search author by name: ");
                    System.out.println("Enter to search:");
                    String authN = scanner.nextLine();
                    authors = authorService.findByParameter("name", authN);
                    printAuthors(authors);
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }

        }

    }

    public static void searchBorrowPrint() {
        System.out.println("[1] Search by copy inventory num");
        System.out.println("[2] Search by reader card num");
        System.out.println("[3] Search by book name");
        System.out.println("[4] Search by borrow date");
        System.out.println("[5] Search by return date");
        System.out.println("[0] Exit");
    }


    public static void searchBorrow() {
        Scanner scanner = new Scanner(System.in);
        List<Borrow> borrows;
        String searchString;
        LocalDateTime dateTime;
        LocalDate date;
        while (true) {
            searchBorrowPrint();
            int option = getNumber();
            switch (option) {
                case 1:
                    System.out.println("Search by inventory num");
                    System.out.println("Enter to search");
                    searchString = scanner.nextLine();
                    borrows = borrowService.findByParameter("copy.inventory_num", searchString);
                    System.out.println("Founded borrows: ");
                    printBorrows(borrows);
                    break;
                case 2:
                    System.out.println("Search by reader card number");
                    System.out.println("Enter to search");
                    searchString = scanner.nextLine();
                    borrows = borrowService.findByParameter("reader.cardNum", searchString);
                    System.out.println("Founded borrows: ");
                    printBorrows(borrows);
                    break;
                case 3:
                    System.out.println("Search by reader book name");
                    System.out.println("Enter to search");
                    searchString = scanner.nextLine();
                    borrows = borrowService.findByParameter("copy.book.book_name", searchString);
                    System.out.println("Founded borrows: ");
                    printBorrows(borrows);
                    break;
                case 4:
                    System.out.println("Search by borrow date");
                    System.out.println("Enter to search");
                    date = getDate();
                    dateTime = date.atStartOfDay();
                    borrows = borrowService.findByDate("borrowDate", dateTime);
                    System.out.println("Founded borrows: ");
                    printBorrows(borrows);
                    break;
                case 5:
                    System.out.println("Search by return date");
                    System.out.println("Enter to search");
                    date = getDate();
                    dateTime = date.atStartOfDay();
                    borrows = borrowService.findByDate("returnDate", dateTime);
                    System.out.println("Founded borrows: ");
                    printBorrows(borrows);
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");

            }
        }
    }


    public static void printBorrowMenu() {
        System.out.println("[1] Get all borrows");
        System.out.println("[2] Borrow book");
        System.out.println("[3] Return book");
        System.out.println("[4] Delete borrow");
        System.out.println("[5] Search borrow");
        System.out.println("[0] Exit");
    }

    public static void borrowMenu() {
        while (true) {
            List<Borrow> borrows;
            Borrow borrow;
            Reader reader;
            int choice;
            List<Reader> readers;
            List<Copy> copies;
            Copy copy;
            LocalDateTime dateTime;
            String name;
            printBorrowMenu();
            int option = getNumber();
            switch (option) {
                case 1:
                    System.out.println("Get all borrows");
                    borrows = borrowService.findAll();
                    printBorrows(borrows);
                    break;
                case 2:
                    System.out.println("Borrow book");
                    readers = readerService.findAll();
                    copies = copyService.findAll();
                    printReaders(readers);
                    System.out.println("Choose the reader to borrow book from 1 to " + readers.size());
                    choice = getNumber(1, readers.size());
                    reader = readers.get(choice - 1);
                    printCopies(copies);
                    System.out.println("Choose the copy of book to borrow from 1 to " + copies.size());
                    choice = getNumber(1, copies.size());
                    copy = copies.get(choice - 1);
                    dateTime = LocalDateTime.now();
                    borrows = borrowService.findByCopy(copy);
                    if ((borrows != null && !borrows.isEmpty() && borrows.get(0).getBorrowDate() != null && borrows.get(0).getReturnDate() != null) || (borrows == null || borrows.isEmpty())) {
                        borrow = new Borrow();
                        borrow.setCopy(copy);
                        borrow.setBorrowDate(dateTime);
                        borrow.setReader(reader);
                        borrow.setReturnDate(null);
                        borrowService.save(borrow);
                    } else {
                        System.out.println("You can't borrow this copy. It's already borrowed");
                        break;
                    }
                    break;
                case 3:
                    System.out.println("Return book city");
                    copies = copyService.findAll();
                    printCopies(copies);
                    System.out.println("Choose the copy of book to return from 1 to " + copies.size());
                    choice = getNumber(1, copies.size());
                    copy = copies.get(choice - 1);
                    borrows = borrowService.findByCopy(copy);
                    if (!borrows.isEmpty() && borrows.get(0).getReturnDate() == null) {
                        borrows.get(0).setCopy(copy);
                        dateTime = LocalDateTime.now();
                        borrows.get(0).setReturnDate(dateTime);
                        borrowService.update(borrows.get(0));
                    } else {
                        System.out.println("You can't return this copy. It's already returned");
                    }
                    break;
                case 4:
                    System.out.println("Delete borrow");
                    borrows = borrowService.findAll();
                    if (borrows.isEmpty()) {
                        System.out.println("The list of borrows is empty. Nothing to delete");
                        break;
                    }
                    printBorrows(borrows);
                    System.out.println("Choose the city from 1 to " + borrows.size());
                    choice = getNumber(1, borrows.size());
                    borrow = borrows.get(choice - 1);
                    borrowService.delete(borrow);
                    break;
                case 5:
                    searchBorrow();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }

        }

    }


    public static void themeCatalog() {
        while (true) {
            List<Theme> themes;
            List<Book> books;
            Book book;
            Theme theme;
            Borrow borrow;
            int choice;
            String name;
            printThemeCatalogMenu();
            int option = getNumber();
            switch (option) {
                case 1:
                    System.out.println("Get all themes");
                    themes = themeService.findAll();
                    printThemeCatalog(themes);
                    break;
                case 2:
                    System.out.println("Add book to theme");
                    System.out.println("Enter city name");
                    books = bookService.findAll();
                    themes = themeService.findAll();
                    printThemes(themes);
                    System.out.println("Choose the theme from 1 to " + themes.size());
                    choice = getNumber(1, themes.size());
                    theme = themes.get(choice - 1);
                    printBooks(books);
                    System.out.println("Choose the book from 1 to " + books.size());
                    choice = getNumber(1, books.size());
                    book = books.get(choice - 1);
                    theme.addBook(book);
                    try {
                        themeService.update(theme);
                    } catch (NonUniqueObjectException ex) {
                        System.out.println("This book was already added to this theme");
                    }

                    break;
                case 3:
                    System.out.println("Remove book from theme");
                    themes = themeService.findAll();
                    printThemes(themes);
                    System.out.println("Choose the theme from 1 to " + themes.size());
                    choice = getNumber(1, themes.size());
                    theme = themes.get(choice - 1);
                    books = new ArrayList<>(theme.getBooks());
                    printBooks(books);
                    System.out.println("Choose the book from 1 to " + books.size());
                    choice = getNumber(1, books.size());
                    book = books.get(choice - 1);
                    theme.remove(book);
                    themeService.update(theme);
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }

        }

    }

}
