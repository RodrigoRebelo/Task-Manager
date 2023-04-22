package com.neff.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "USERS")
public class User extends AbstractModel{

    @Column(name = "USERNAME")
    private String username;

    @Column(name = "PASSWORD")
    private String password;

    @OneToMany(mappedBy = "user")
    private List<Task> tasks;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void addTask(Task task) {
        tasks.add(task);
        task.setUser(this);
    }
}