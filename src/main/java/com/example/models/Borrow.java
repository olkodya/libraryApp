package com.example.models;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "borrows")
public class Borrow {

    @Id
    @Column(name = "borrow_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "borrow_date", nullable = true)

    private LocalDateTime borrowDate;

    @Column(name = "return_date", nullable = true)

    private LocalDateTime returnDate;
    @ManyToOne
    @JoinColumn(name = "reader_id", referencedColumnName = "reader_id")
    private Reader reader;

    @ManyToOne
    @JoinColumn(name = "copy_id", referencedColumnName = "copy_id")
    private Copy copy;

    public Borrow(LocalDateTime borrowDate, LocalDateTime returnDate, Reader reader, Copy copy) {
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
        this.reader = reader;
        this.copy = copy;
        copy.addBorrow(this);
        reader.addBorrow(this);
    }

    public Borrow() {
    }

    public Reader getReader() {
        return reader;
    }

    public void setReader(Reader reader) {
        this.reader = reader;
    }

    public LocalDateTime getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(LocalDateTime borrowDate) {
        this.borrowDate = borrowDate;
    }

    public LocalDateTime getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDateTime returnDate) {
        this.returnDate = returnDate;
    }

    public Long getId() {
        return id;
    }

    public Copy getCopy() {
        return copy;
    }

    public void setCopy(Copy copy) {
        this.copy = copy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Borrow borrow = (Borrow) o;
        return Objects.equals(id, borrow.id) && Objects.equals(borrowDate, borrow.borrowDate) && Objects.equals(returnDate, borrow.returnDate) && Objects.equals(reader, borrow.reader) && Objects.equals(copy, borrow.copy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, borrowDate, returnDate, reader, copy);
    }
}
