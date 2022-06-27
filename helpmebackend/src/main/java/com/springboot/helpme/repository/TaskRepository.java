package com.springboot.helpme.repository;

import com.springboot.helpme.entity.Task;
import com.springboot.helpme.entity.TaskItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task,Integer> {
    @Query("select new com.springboot.helpme.entity.TaskItem(u,t) from User u," +
            "Task t where t.publisherid=u.id and t.status='waiting for receiving'")
    List<TaskItem> listAll();

    @Query("select new com.springboot.helpme.entity.TaskItem(u,t) from User u, " +
            "Task t where t.publisherid=u.id and t.id=?1 " +
            "and t.status='waiting for receiving'")
    TaskItem itemById(Integer taskid);
}
