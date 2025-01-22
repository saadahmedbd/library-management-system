package com.saad.library.management.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class book_data {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private long id;

    private String title;

    private String author;

    private String genre;

    private String language;

    private Date published_year;

    @ManyToOne
    @JoinColumn(name = "library_id")
    private library library;

    @OneToMany(mappedBy = "bookData", cascade = CascadeType.ALL)
    private List<borrow_book> borrowBooks=new ArrayList<>();

    @OneToMany(mappedBy = "bookData",cascade = CascadeType.ALL)
    private List<book_review> bookReviews=new ArrayList<>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Date getPublished_year() {
        return published_year;
    }

    public void setPublished_year(Date published_year) {
        this.published_year = published_year;
    }

    public com.saad.library.management.model.library getLibrary() {
        return library;
    }

    public void setLibrary(com.saad.library.management.model.library library) {
        this.library = library;
    }

    public List<borrow_book> getBorrowBooks() {
        return borrowBooks;
    }

    public void setBorrowBooks(List<borrow_book> borrowBooks) {
        this.borrowBooks = borrowBooks;
    }

    public List<book_review> getBookReviews() {
        return bookReviews;
    }

    public void setBookReviews(List<book_review> bookReviews) {
        this.bookReviews = bookReviews;
    }
}
