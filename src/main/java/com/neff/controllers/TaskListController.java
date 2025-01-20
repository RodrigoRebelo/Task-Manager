package com.neff.controllers;

import com.neff.model.TaskList;
import com.neff.service.TaskListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskListController {

    @Autowired
    TaskListService taskListService;

    @GetMapping(value = "/api/tasks/{userId}/tasklist/all/", consumes = {"*/*"})
    public List<TaskList> getAllTaskListsByUserId (@PathVariable("userId") int userId){
        return taskListService.getAllTaskListsByUserId(userId);
    }

    @GetMapping(value = "/api/tasks/{userId}/tasklist/{taskListId}/", consumes = {"*/*"})
    public TaskList getTaskListByUserId (@PathVariable("userId") int userId, @PathVariable("taskListId") int taskListId){
        return taskListService.getTaskListById(userId, taskListId);
    }

    @PostMapping(value = "/api/tasks/{userId}/tasklist/new/{taskListName}", consumes = {"*/*"})
    public void addTaskListByUserId (@PathVariable("userId") int userId, @PathVariable("taskListName") String taskListName){
        taskListService.addTaskList(userId, taskListName);
    }

}
