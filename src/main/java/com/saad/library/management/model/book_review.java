package com.saad.library.management.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class book_review {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private long id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private libraryUser libraryUser;
    @ManyToOne
    @JoinColumn(name = "book_id")
    private book_data bookData;

    private float rating;
    private String comment;
}
