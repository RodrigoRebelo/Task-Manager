package com.neff.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "TASK_LIST")
public class TaskList {

    @Id
    @GeneratedValue ( strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private User user;

    @Column(name = "NAME")
    private String taskListName;

    @OneToMany(mappedBy = "task")
    List<Task> tasks;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getTaskListName() {
        return taskListName;
    }

    public void setTaskListName(String taskListName) {
        this.taskListName = taskListName;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
}
