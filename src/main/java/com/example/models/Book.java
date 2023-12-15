package com.example.models;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

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

    @ManyToOne()
    @JoinColumn(name = "publisher_id")
    private Publisher publisher;

    @Column(name = "publish_year")
    private int publishYear;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "books_authors", joinColumns = {@JoinColumn(name = "book_id")}
            , inverseJoinColumns = {@JoinColumn(name = "author_id")})
    private Set<Author> authors = new HashSet<>();

    @ManyToMany(mappedBy = "books", fetch = FetchType.EAGER)
    private Set<Theme> themes;

    @OneToMany(mappedBy = "book", fetch = FetchType.EAGER)
    private Set<Copy> copies = new HashSet<>();

    public Book() {

    }

    public Book(String isbn, String book_name, Integer pages, BigDecimal price, Publisher publisher, Set<Author> authors) {
        this.isbn = isbn;
        this.book_name = book_name;
        this.pages = pages;
        this.price = price;
        this.publisher = publisher;
        authors = new HashSet<>();
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

    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }

    public Set<Theme> getThemes() {
        return themes;
    }

    public void setThemes(Set<Theme> themes) {
        this.themes = themes;
    }

    public int getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(int publishYear) {
        this.publishYear = publishYear;
    }

    public Set<Copy> getCopies() {
        return copies;
    }

    public void setCopies(Set<Copy> copies) {
        this.copies = copies;
    }
//    @Override
//    public String toString() {
//        return "Book{" +
//                "id=" + id +
//                ", isbn='" + isbn + '\'' +
//                ", book_name='" + book_name + '\'' +
//                ", pages=" + pages +
//                ", price=" + price +
//                ", copiesAmount=" + copiesAmount +
//                '}';
//    }

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
        return Objects.hash(id, isbn, book_name, pages, price, publisher, authors);
    }
}
