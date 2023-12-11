package com.example.models;


import javax.persistence.*;

@Entity
@Table (name = "publishers")
public class Publisher {
    @Id
    @Column (name = "publisher_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column (name = "publisher_name")
    String name;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "city_id")
    City city;

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

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
