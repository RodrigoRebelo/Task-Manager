package com.neff.repo;

import com.neff.model.TaskList;
import com.neff.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskListRepository extends CrudRepository<TaskList, Integer> {

    @Query(value = "SELECT t1 FROM TaskList t1 WHERE t1.user.id = ?1" )
    List<TaskList> getAllTaskListsByUserId(int id);

    @Query(value = "SELECT t1 FROM TaskList t1 WHERE t1.user.id = ?1 AND t1.id = ?2" )
    TaskList getTaskListByUserId(int userId, int taskListId);

}
