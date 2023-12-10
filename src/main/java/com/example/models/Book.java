package com.example.models;

import jdk.jfr.Name;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Collection;

@Entity
@Table (name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "book_id")
    private Long id;

    @Column (name = "isbn")
    private String isbn;

    @Column (name = "book_name")
    private String book_name;

    @Column (name = "pages")
    private Integer pages;

    @Column (name = "price")
    private BigDecimal price;

    @Column (name = "copies_amount")
    private Integer copiesAmount;

//    @ManyToMany
//    private Collection<Author> book_id;
    public Book() {

    }

    public Book(String isbn, String book_name, Integer pages, BigDecimal price, Integer copiesAmount) {
        this.isbn = isbn;
        this.book_name = book_name;
        this.pages = pages;
        this.price = price;
        this.copiesAmount = copiesAmount;
    }

    public Long getId() {
        return id;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getBook_name() {
        return book_name;
    }

    public Integer getPages() {
        return pages;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Integer getCopiesAmount() {
        return copiesAmount;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setCopiesAmount(Integer copiesAmount) {
        this.copiesAmount = copiesAmount;
    }


//    public Collection<Author> getBook_id() {
//        return book_id;
//    }
//
//    public void setBook_id(Collection<Author> book_id) {
//        this.book_id = book_id;
//    }
}
