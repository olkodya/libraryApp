package com.example;

import com.example.models.Author;
import com.example.models.Book;
import com.example.services.AuthorService;
import com.example.services.BookService;
import com.example.utils.Menu;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Menu.run();
        AuthorService authorService = new AuthorService();
        BookService bookService = new BookService();
        Book book = bookService.findById(15L);
        System.out.println("********************");
        System.out.println(book.getAuthors());
        Author author = authorService.findById(2L);
        book.removeAuthor(author);
        System.out.println("********************");
        System.out.println(book.getAuthors());
        System.out.println(author.getBooks());
        authorService.update(author.getId());
        bookService.update(book);
        List<Book> bookSet = bookService.findAll();
        for (Book bookk : bookSet) {
            System.out.println(bookk.getAuthors());
        }
        Menu.run();
    }
}