package com.example.models;

import javax.persistence.*;

@Entity
@Table (name = "cities")
public class City {

    @Id
    @Column (name = "city_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name = "city_name")
    private String name;

    public City() {

    }

    public City(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
