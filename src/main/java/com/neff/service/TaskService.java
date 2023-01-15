package com.neff.service;

import com.neff.model.Task;
import com.neff.repo.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskService {

    @Autowired
    TaskRepository taskRepository;

    public List<Task> getAllTasks() {
        List<Task> tasks = new ArrayList<>();
        taskRepository.findAll().forEach(tasks::add);
        return tasks;
    }

    public Task getTaskById(int id) {
        return taskRepository.findById(id).get();
    }

    public void saveOrUpdate (Task task) {
        taskRepository.save(task);
    }

    public void delete(int id) {
        if (getAllTasks().isEmpty()) {
            return;
        } else {
            taskRepository.deleteById(id);
        }
    }

}
