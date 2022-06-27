package com.springboot.helpme.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String username;
    private String password;
    private String email;
    private String university;
    private String telenumber;
    private String stuid;
    private String department;
    private String city;
    private String schdis;
    private String dorm;
    private Integer publishing;
    private Integer receiving;
    private Integer published;
    private Integer solved;
}
