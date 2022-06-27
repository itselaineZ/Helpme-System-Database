package com.springboot.helpme.controller;

import com.springboot.helpme.entity.Notification;
import com.springboot.helpme.entity.Task;
import com.springboot.helpme.entity.TaskItem;
import com.springboot.helpme.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskHandler {
    @Autowired
    private TaskRepository taskRepository;

    @GetMapping("/findAll")
    public List<Task> findAll(){
        return taskRepository.findAll();
    }

    @GetMapping("/listAll")
    public List<TaskItem> listAll(){
        return taskRepository.listAll();
    }

    @GetMapping("/itemById")
    public TaskItem itemById(@Param("taskid") int taskid){
        return taskRepository.itemById(taskid);
    }

    @PostMapping("/save")
    public int save(@RequestBody Task task){
        task.setStatus("waiting for receiving");
        Task result = taskRepository.save(task);
        if (result != null){
            return result.getId();
        }else{
            return -1;
        }
    }

    @PostMapping("/receive")
    public int receive(@RequestBody Task task){
        task.setStatus("received");
        Task result = taskRepository.save(task);
        if (result != null){
            return result.getId();
        }else{
            return -1;
        }
    }

    @GetMapping("/deleteById")
    public String deleteById(@Param("taskid") int taskid){
        taskRepository.deleteById(taskid);
        return "success";
    }
}
