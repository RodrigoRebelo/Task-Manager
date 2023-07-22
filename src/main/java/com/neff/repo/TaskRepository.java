package com.neff.repo;

import com.neff.model.Task;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends CrudRepository<Task, Integer> {

/*    @Query("SELECT Task task WHERE task.user = ?1")
    List<Task> findByUser(String user);*/

}
