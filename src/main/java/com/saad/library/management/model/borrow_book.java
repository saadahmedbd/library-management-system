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
}
