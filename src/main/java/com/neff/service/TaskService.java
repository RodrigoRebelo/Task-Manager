package com.neff.service;

import com.neff.exceptions.UserErrorException;
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
     Task task = new Task();
        if(taskRepository.findById(id).isPresent()){
            task = taskRepository.findById(id).get();
        }
        return task;
    }

    public void saveOrUpdate (Task task) {
        taskRepository.save(task);
    }

    public void delete(int id) {
        if (getAllTasks().isEmpty()) {
            throw new UserErrorException("NO USER FOUND");
        } else {
            taskRepository.deleteById(id);
        }
    }

}
