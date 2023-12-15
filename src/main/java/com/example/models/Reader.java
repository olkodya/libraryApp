package com.example.models;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "readers",
        uniqueConstraints = @UniqueConstraint(name = "readers_reader_card_num_key", columnNames = {"reader_card_num"}))
public class Reader {

    @OneToMany(mappedBy = "reader", cascade = CascadeType.ALL)
    List<Borrow> borrows;
    @Id
    @Column(name = "reader_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "reader_card_num")
    private String cardNum;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @Column(name = "phone_number")
    private String phoneNumber;

    public Reader(String cardNum, String lastName, String firstName, String middleName, LocalDate birthDate, String phoneNumber) {
        this.cardNum = cardNum;
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.birthDate = birthDate;
        this.phoneNumber = phoneNumber;
        borrows = new ArrayList<>();
    }

    public Reader() {

    }

    public Long getId() {
        return id;
    }

    public String getCardNum() {
        return cardNum;
    }

    public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public void addBorrow(Borrow borrow) {
        borrows.add(borrow);
    }

    public List<Borrow> getBorrows() {
        return borrows;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setBorrows(List<Borrow> borrows) {
        this.borrows = borrows;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reader reader = (Reader) o;
        return Objects.equals(borrows, reader.borrows) && Objects.equals(id, reader.id) && Objects.equals(cardNum, reader.cardNum) && Objects.equals(lastName, reader.lastName) && Objects.equals(firstName, reader.firstName) && Objects.equals(middleName, reader.middleName) && Objects.equals(birthDate, reader.birthDate) && Objects.equals(phoneNumber, reader.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(borrows, id, cardNum, lastName, firstName, middleName, birthDate, phoneNumber);
    }
}

