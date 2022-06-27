package com.springboot.helpme.repository;

import com.springboot.helpme.entity.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface NotificationRepository extends JpaRepository<Notification,Integer> {
    @Query("select msg from Notification msg where msg.receiverid=?1")
    List<Notification> findByReceiver(Integer receiverid);
}
