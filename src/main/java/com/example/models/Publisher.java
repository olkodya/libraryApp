package com.example.models;


import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "publishers")
public class Publisher {
    @OneToMany(mappedBy = "publisher", fetch = FetchType.EAGER)
    Set<Book> books;
    @Column(name = "publisher_name")
    String name;
    @ManyToOne()
    @JoinColumn(name = "city_id")
    City city;
    @Id
    @Column(name = "publisher_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Publisher(String name, City city) {
        this.name = name;
        this.city = city;
    }

    public Publisher() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Publisher publisher = (Publisher) o;
        return Objects.equals(name, publisher.name) && Objects.equals(city, publisher.city) && Objects.equals(id, publisher.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, city, id);
    }
}
