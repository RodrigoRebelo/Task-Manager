package com.neff.controller;

import com.neff.model.Task;
import com.neff.service.TaskService;
import com.neff.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskController {

    @Autowired
    TaskService taskService;

    @Autowired
    UserService userService;


    @GetMapping(value = "/api/tasks", consumes = {"*/*"})
    public List<Task> getAllTasks () {
        return taskService.getAllTasks();
    }

    @GetMapping(value = "/api/tasks/{userId}/tasks/{taskId}", consumes = {"*/*"})
    public void getTask ( @PathVariable("userId") int userId, @PathVariable("taskId") int taskId){
        //return taskService.getTaskById(taskId);
    }

    @DeleteMapping(value = "/api/tasks/{id}", consumes = {"*/*"})
    public void deleteTask ( @PathVariable("id") int id){
        taskService.delete(id);
    }

    @PostMapping(value = "/api/users/{userId}/tasks", consumes = {"*/*"})
    public void saveTask (@PathVariable("userId") int userId, @RequestBody Task taskBody) {

        userService.getUserById(userId);
        taskService.saveOrUpdate(userService.addTask(userId, taskBody));
    }
}
