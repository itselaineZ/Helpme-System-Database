package com.springboot.helpme.controller;

import com.springboot.helpme.entity.Notification;
import com.springboot.helpme.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/notification")
public class NotificationHandler {
    @Autowired
    private NotificationRepository notificationRepository;

    @GetMapping("/findByReceiver")
    private List<Notification> findByReceiver(@Param("receiverid") int receiverid) {
        return notificationRepository.findByReceiver(receiverid);
    }

    @PostMapping("/save")
    private String save(@RequestBody Notification notification){
        Notification result = notificationRepository.save(notification);
        if (result != null){
            return "success";
        }else {
            return "error";
        }
    }

    @GetMapping("/findById")
    private Optional<Notification> findById(@Param("id") int id){
        return notificationRepository.findById(id);
    }
}
