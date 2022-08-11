package com.SISP.server.flutter.SISP.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/User")
public class UserController {


    @Autowired
    UserService userService;

    @GetMapping
    public List<User> getUser(){
        return userService.getUser();
    }


    @PostMapping("/insert")
    public void insertUser(@RequestBody User user){
        userService.insertUser(user);
    }
}
