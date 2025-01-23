package com.saad.library.management.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class libraryUser {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private long id;

    private String userName;

    private String email;

    private String phone;

    private String address;

    @OneToMany(mappedBy = "libraryUser", cascade = CascadeType.ALL)
    private List<borrow_book> borrowBooks=new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "library_id")
    private library library;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<borrow_book> getBorrowBooks() {
        return borrowBooks;
    }

    public void setBorrowBooks(List<borrow_book> borrowBooks) {
        this.borrowBooks = borrowBooks;
    }

    public com.saad.library.management.model.library getLibrary() {
        return library;
    }

    public void setLibrary(com.saad.library.management.model.library library) {
        this.library = library;
    }
}
