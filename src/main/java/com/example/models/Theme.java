package com.example.models;

import javax.persistence.*;

@Entity
@Table (name = "themes")
public class Theme {

    @Id
    @Column (name = "theme_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "theme_name")
    private String name;

    public Theme() {
    }

    public Theme(Long id, String name) {
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
}
