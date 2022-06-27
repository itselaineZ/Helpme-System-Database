package com.springboot.helpme.repository;

import com.springboot.helpme.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void findAll(){
        System.out.println(userRepository.findAll());
    }

    @Test
    void save(){
        User user = new User();
        user.setUsername("root");
        user.setPassword("root");
        user.setEmail("1952339@tongji.edu.cn");
        user.setTelenumber("123456789101");
        user.setStuid("1952339");
        User user1 = userRepository.save(user);
        System.out.println(user1);
    }

    @Test
    void findByUsername(){
        User user = new User();
        user.setUsername("root");
        user.setPassword("root");
        User user1 = userRepository.findByUsername(user.getUsername());
        System.out.println(user1);
    }

    @Test
    void UpdateUser(){
        User user = new User();
        user.setId(5);
        user.setUsername("admin1");
        user.setPassword("admin");
        user.setEmail("1952339@tongji.edu.cn");
        user.setTelenumber("123456789101");
        user.setStuid("1952339");
        User user1 = userRepository.save(user);
        System.out.println(user1);
    }
}