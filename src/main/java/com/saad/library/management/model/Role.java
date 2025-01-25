package com.saad.library.management.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Role {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private long id;
    private String name;
    @ManyToMany(mappedBy = "roles")
    private Set<security_User> users;
}
