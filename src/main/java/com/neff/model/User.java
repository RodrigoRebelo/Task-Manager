package com.neff.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "USERS")
public class User extends AbstractModel{

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

    public void addTask(Task task) {
        tasks.add(task);
        task.setUser(this);
    }
}