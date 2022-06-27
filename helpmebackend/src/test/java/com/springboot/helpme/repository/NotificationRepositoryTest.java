package com.springboot.helpme.repository;

import com.springboot.helpme.entity.Notification;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class NotificationRepositoryTest {
    @Autowired
    private NotificationRepository notificationRepository;

    @Test
    void findByReceiver(){
        System.out.println(notificationRepository.findByReceiver(4));
    }

}
