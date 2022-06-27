package com.springboot.helpme.entity;

import java.io.Serializable;

public class TaskItem implements Serializable {
    private User userdata;
    private Task taskdata;

    public TaskItem(){}
    public TaskItem(User u){
        this.taskdata = new Task();
        this.userdata = u;
    }
    public TaskItem(Task t){
        this.userdata = new User();
        this.taskdata = t;
    }
    public TaskItem(User u, Task t){
        this.userdata = u;
        this.taskdata = t;
    }

    public User getUserdata() {
        return this.userdata;
    }
    public Task getTaskdata(){
        return this.taskdata;
    }
}
