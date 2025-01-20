package com.saad.library.management.model;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class library {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private long id;

    private String name;

    private String location;
    private long contract;
    @OneToMany(mappedBy = "library", cascade = CascadeType.ALL)
    private List <book_data> bookData=new ArrayList<>();

    @OneToMany(mappedBy = "library", cascade = CascadeType.ALL)
    private List<libraryUser> libraryUsers =new ArrayList<>();
    @OneToMany(mappedBy = "library", cascade = CascadeType.ALL)
    private  List<borrow_book> borrowBooks =new ArrayList<>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public long getContract() {
        return contract;
    }

    public void setContract(long contract) {
        this.contract = contract;
    }

    public List<book_data> getBookData() {
        return bookData;
    }

    public void setBookData(List<book_data> bookData) {
        this.bookData = bookData;
    }

    public List<libraryUser> getLibraryUsers() {
        return libraryUsers;
    }

    public void setLibraryUsers(List<libraryUser> libraryUsers) {
        this.libraryUsers = libraryUsers;
    }

    public List<borrow_book> getBorrowBooks() {
        return borrowBooks;
    }

    public void setBorrowBooks(List<borrow_book> borrowBooks) {
        this.borrowBooks = borrowBooks;
    }
}
