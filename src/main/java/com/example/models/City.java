package com.example.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "cities")
public class City {

    @Id
    @Column (name = "city_id")
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
