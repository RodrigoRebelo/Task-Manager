package com.neff.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "USERS")
public class User {

    @Id @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "PASSWORD")
    private String password;

    @OneToMany(mappedBy = "user")
    private List<Task> tasks;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}