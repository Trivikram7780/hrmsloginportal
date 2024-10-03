package com.vikram.hrmsloginportl.controller;


import com.vikram.hrmsloginportl.Entity.Usersdata;
import com.vikram.hrmsloginportl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public Usersdata registerUser(@RequestBody Usersdata user){
         return userService.saveInDb(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody Usersdata user){
        System.out.println(user.getUsername());
        return userService.verify(user);
    }
}
