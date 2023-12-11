package com.example.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "authors")
public class Author {

    @ManyToMany(mappedBy = "authors")
    List<Book> books;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "author_id")
    private Long id;
    @Column(name = "author_name")
    private String name;

    public Author(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Author() {

    }

    public Author(String name) {
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

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
