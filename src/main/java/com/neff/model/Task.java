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
    @Column(name = "TASK_PRIORITY")
    private TaskPriorityEnum taskPriority;

    @Autowired
    @Column
    private TaskStatusEnum taskStatus;

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public TaskPriorityEnum getPriority() {
        return taskPriority;
    }

    public void setPriority(TaskPriorityEnum taskPriority) {
        this.taskPriority = taskPriority;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
