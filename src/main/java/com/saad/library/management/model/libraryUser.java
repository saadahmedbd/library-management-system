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

    private String name;

    private String email;

    private double phone;

    private String address;

    @OneToMany(mappedBy = "libraryUser", cascade = CascadeType.ALL)
    private List<borrow_book> borrowBooks=new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "library_id")
    private library library;

    @OneToMany(mappedBy = "libraryUser", cascade = CascadeType.ALL)
    private List<book_review> bookReviews=new ArrayList<>();
}
