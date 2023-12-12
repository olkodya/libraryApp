package com.example.models;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "books",
        uniqueConstraints = @UniqueConstraint(name = "books_isbn_key", columnNames = {"isbn"})
)
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private Long id;

    @Column(name = "isbn")
    private String isbn;

    @Column(name = "book_name")
    private String book_name;

    @Column(name = "pages")
    private Integer pages;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "copies_amount")
    private Integer copiesAmount;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "publisher_id")
    private Publisher publisher;

    @ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @JoinTable(name = "books_authors", joinColumns = {@JoinColumn(name = "book_id")}
            , inverseJoinColumns = {@JoinColumn(name = "author_id")})
    private List<Author> authors = new ArrayList<>();

//    @ManyToMany
//    private List<Theme> themes;

    @OneToMany(mappedBy = "book")
    private List<Copy> copies;

    public Book() {

    }

    public Book(String isbn, String book_name, Integer pages, BigDecimal price, Integer copiesAmount, Publisher publisher, List<Author> authors) {
        this.isbn = isbn;
        this.book_name = book_name;
        this.pages = pages;
        this.price = price;
        this.copiesAmount = copiesAmount;
        this.publisher = publisher;
        authors = new ArrayList<>();
        //themes = new ArrayList<>();
        this.authors = authors;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getCopiesAmount() {
        return copiesAmount;
    }

    public void setCopiesAmount(Integer copiesAmount) {
        this.copiesAmount = copiesAmount;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public void addAuthor(Author author) {
        authors.add(author);
        author.books.add(this);
    }

    public void removeAuthor(Author author) {
        authors.remove(author);
        author.getBooks().remove(this);
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", isbn='" + isbn + '\'' +
                ", book_name='" + book_name + '\'' +
                ", pages=" + pages +
                ", price=" + price +
                ", copiesAmount=" + copiesAmount +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Book book = (Book) o;
        return Objects.equals(this.id, ((Book) o).id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, isbn, book_name, pages, price, copiesAmount, publisher, authors);
    }
}
