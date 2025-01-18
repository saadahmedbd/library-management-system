package com.saad.library.management.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class book_data {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private long id;
    @Column(
            nullable = false
    )
    private String title;
    @Column(
            nullable = false
    )
    private String author;
    @Column(
            nullable = false
    )
    private String genre;
    @Column(
            nullable = false
    )
    private String language;
    @Column(
            nullable = false
    )
    private Date published_year;

    @ManyToOne
    @JoinColumn(name = "library_id")
    private library library;

    @OneToMany(mappedBy = "bookData", cascade = CascadeType.ALL)
    private List<borrow_book> borrowBooks=new ArrayList<>();

    @OneToMany(mappedBy = "bookData",cascade = CascadeType.ALL)
    private List<book_review> bookReviews=new ArrayList<>();

}
