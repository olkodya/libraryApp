package com.example.models;

import javax.persistence.*;

@Entity
@Table (name = "copies")
public class Copy {
    @Id
    @Column (name = "copy_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name = "inventory_num")
    private String inventory_num;

    //book_id???

    public Copy() {

    }

    public Copy(Long id, String inventory_num) {
        this.id = id;
        this.inventory_num = inventory_num;
    }

    public void setInventory_num(String inventory_num) {
        this.inventory_num = inventory_num;
    }

    public String getInventory_num() {
        return inventory_num;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
