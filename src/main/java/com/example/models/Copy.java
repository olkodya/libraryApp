package com.example.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
    @ManyToOne()
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

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Copy copy = (Copy) o;
        return Objects.equals(id, copy.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, inventory_num, borrows, book);
    }
}
