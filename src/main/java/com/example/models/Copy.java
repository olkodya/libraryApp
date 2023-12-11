package com.example.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "copies",
        uniqueConstraints = @UniqueConstraint(name = "copies_inventory_num_key", columnNames = "inventory_num"))
public class Copy {
    @Id
    @Column(name = "copy_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "inventory_num")
    private String inventory_num;

    @OneToMany(mappedBy = "copy")
    private List<Borrow> borrows;
    @ManyToOne
    @JoinColumn(name = "book_id", referencedColumnName = "book_id")
    private Book book;

    public Copy() {

    }

    public Copy(Long id, String inventory_num, Book book) {
        this.id = id;
        this.inventory_num = inventory_num;
        this.book = book;
        borrows = new ArrayList<>();
    }

    public String getInventory_num() {
        return inventory_num;
    }

    public void setInventory_num(String inventory_num) {
        this.inventory_num = inventory_num;
    }

    public Long getId() {
        return id;
    }

    public void addBorrow(Borrow borrow) {
        borrows.add(borrow);
    }
}
