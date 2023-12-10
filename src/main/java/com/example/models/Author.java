package com.example.models;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table (name = "authors")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "author_id")
    private Long id;

    @Column(name = "author_name")
    private String name;

//    @ManyToMany(mappedBy = "book_id")
//    private Collection<Book> author_id;
    public Author() {

    }

    public Author(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }


//    public Collection<Book> getAuthor_id() {
//        return author_id;
//    }
//
//    public void setAuthor_id(Collection<Book> author_id) {
//        this.author_id = author_id;
//    }
}
