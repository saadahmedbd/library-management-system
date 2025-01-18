package com.saad.library.management.model;

import jakarta.persistence.*;


@Entity
public class book_review {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private long id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private user user;
    @ManyToOne
    @JoinColumn(name = "book_id")
    private book_data bookData;

    private float rating;
    private String comment;
}
