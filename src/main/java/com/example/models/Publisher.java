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

//    @OneToOne (mappedBy = "")
//    private City city;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
