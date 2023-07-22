package com.neff.service;

import com.neff.model.TaskList;
import com.neff.model.User;
import com.neff.repo.TaskListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskListService {

    @Autowired
    UserService userService;

    @Autowired
    TaskListRepository taskListRepository;

    public TaskList getTaskListById(int id, int taskListId) {

        User user = userService.getUserById(id);
/*        if (!taskListRepository.existsById(id)) {
            throw new TaskListErrorException("LIST NOT FOUND");
        }*/
        return taskListRepository.getTaskListByUserId(user.getId(), taskListId);
    }

    public List<TaskList> getAllTaskListsByUserId(int id) {
        userService.getUserById(id);
        return taskListRepository.getAllTaskListsByUserId(id);
    }

    public void addTaskList(int id, String taskListName) {

        if (id != 0 && !taskListName.isEmpty()) {
            TaskList taskList = new TaskList();
            taskList.setUser(userService.getUserById(id));
            taskList.setTaskListName(taskListName);
            taskListRepository.save(taskList);
        }
    }
}
