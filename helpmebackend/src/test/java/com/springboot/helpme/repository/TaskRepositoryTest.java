package com.springboot.helpme.repository;

import com.springboot.helpme.entity.Task;
import com.springboot.helpme.entity.TaskItem;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Iterator;
import java.util.List;

@SpringBootTest
public class TaskRepositoryTest {
    @Autowired
    private TaskRepository taskRepository;

    @Test
    void findAll(){
        System.out.println(taskRepository.findAll());
    }

    @Test
    void listAll() {
        System.out.println(taskRepository.listAll());
    }

    @Test
    void itemById(){
        System.out.println(taskRepository.itemById(1));
    }

    @Test
    void save(){
        Task task = new Task();
        task.setPublisherid(4);
        task.setTitle("Helpme");
        task.setStatus("sending to backend");
        Task task1 = taskRepository.save(task);
        System.out.println(task1);
    }

    @Test
    void deleteById(){
        taskRepository.deleteById(1);
    }
}
