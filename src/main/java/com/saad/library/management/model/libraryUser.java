package com.saad.library.management.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class libraryUser {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false,
        unique = true
    )
    private String email;

    private double phone;
    @Column(nullable = false)
    private String address;

    @OneToMany(mappedBy = "libraryUser", cascade = CascadeType.ALL)
    private List<borrow_book> borrowBooks=new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "library_id")
    private library library;

    @OneToMany(mappedBy = "libraryUser", cascade = CascadeType.ALL)
    private List<book_review> bookReviews=new ArrayList<>();
}
