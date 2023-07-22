package com.neff.model;

import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name = "TASK")
public class Task {

    @Id
    @GeneratedValue ( strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    private TaskList taskList;

    @Column(name = "TASK")
    private String task;

    @Autowired
    @Column(name = "TASK_PRIORITY")
    private TaskPriorityEnum taskPriority;

    @Autowired
    @Column
    private TaskStatusEnum taskStatus;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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
}
