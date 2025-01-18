package com.saad.library.management.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class library {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String location;
    private double contract;
    @OneToMany(mappedBy = "library", cascade = CascadeType.ALL)
    private List <book_data> bookData=new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<user> users=new ArrayList<>();
    @OneToMany(mappedBy = "library", cascade = CascadeType.ALL)
    private  List<borrow_book> borrowBooks =new ArrayList<>();
}
