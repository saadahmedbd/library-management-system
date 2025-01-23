package com.saad.library.management.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class borrow_book {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private long id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private libraryUser libraryUser;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private book_data bookData;

    @ManyToOne
    @JoinColumn(name = "library_id")
    private library library;

    private LocalDate borrow_date;
    private LocalDate return_date;
    private String status;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public com.saad.library.management.model.libraryUser getLibraryUser() {
        return libraryUser;
    }

    public void setLibraryUser(com.saad.library.management.model.libraryUser libraryUser) {
        this.libraryUser = libraryUser;
    }

    public book_data getBookData() {
        return bookData;
    }

    public void setBookData(book_data bookData) {
        this.bookData = bookData;
    }

    public com.saad.library.management.model.library getLibrary() {
        return library;
    }

    public void setLibrary(com.saad.library.management.model.library library) {
        this.library = library;
    }

    public LocalDate getBorrow_date() {
        return borrow_date;
    }

    public void setBorrow_date(LocalDate borrow_date) {
        this.borrow_date = borrow_date;
    }

    public LocalDate getReturn_date() {
        return return_date;
    }

    public void setReturn_date(LocalDate return_date) {
        this.return_date = return_date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
