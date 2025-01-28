package com.saad.library.management.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data


public class Role {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private long id;
    private String name;

    @ManyToMany(mappedBy = "roles")
    private Set<security_User> users =new HashSet<>();

    public Role() {
    }

    public Role(long id, String name, Set<security_User> users) {
        this.id = id;
        this.name = name;
        this.users = users;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<security_User> getUsers() {
        return users;
    }

    public void setUsers(Set<security_User> users) {
        this.users = users;
    }
}
