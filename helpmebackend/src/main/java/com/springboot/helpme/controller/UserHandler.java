package com.springboot.helpme.controller;

import com.springboot.helpme.entity.User;
import com.springboot.helpme.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserHandler {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/findAll")
    public List<User> findAll(){
        return userRepository.findAll();
    }

    @PostMapping("/save")
    public String save(@RequestBody User user){
        User result = userRepository.save(user);
        if (result != null){
            return "success";
        }else {
            return "error";
        }
    }

    @PostMapping("/findByUsername")
    public User findByUsername(@RequestBody User user){
        System.out.println(user);
        User result = userRepository.findByUsername(user.getUsername());
        System.out.println(result);
        if(user.getPassword().equals(result.getPassword())) {
            result.setPassword("");
            return result;
        }else
            return null;
    }

    @PostMapping("/updateUserTaskInfo")
    public void updateUserTaskInfo(@RequestBody User user){
        System.out.println(user);
        userRepository.updatePublishing(user.getPublishing(), user.getId());
        userRepository.updateReceiving(user.getReceiving(), user.getId());
        userRepository.updatePublished(user.getPublished(), user.getId());
        userRepository.updateSolved(user.getSolved(), user.getId());
    }
}
