package com.saad.library.management.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class security_User {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private long id;
    private String username;
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name =
            "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles;

}
