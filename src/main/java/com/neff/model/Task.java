package com.neff.model;

import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name = "TASK")
public class Task extends AbstractModel{

    @ManyToOne
    private User user;

    @Column(name = "TASK")
    private String task;

    @Autowired
    @Column(name = "PRIORITY")
    private TaskPriority priority;

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public TaskPriority getPriority() {
        return priority;
    }

    public void setPriority(TaskPriority priority) {
        this.priority = priority;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
