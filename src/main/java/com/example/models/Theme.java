package com.example.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "themes")
public class Theme {

    @Id
    @Column(name = "theme_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @JoinTable(name = "books_themes", joinColumns = {@JoinColumn(name = "theme_id")}
            , inverseJoinColumns = {@JoinColumn(name = "book_id")})
    Set<Book> books = new HashSet<>();
    @Column(name = "theme_name")
    private String name;

    public Theme() {
    }

    public Theme(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    public void addBook(Book book) {
        this.books.add(book);
        book.getThemes().add(this);
    }

    public void remove(Book book) {
        this.books.remove(book);
        book.getThemes().remove(this);
    }

//    @Override
//    public String toString() {
//        return "Theme{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                '}';
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Theme theme = (Theme) o;
        return Objects.equals(id, theme.id) && Objects.equals(name, theme.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
