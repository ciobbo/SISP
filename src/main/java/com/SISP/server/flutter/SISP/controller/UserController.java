package com.SISP.server.flutter.SISP.controller;

import com.SISP.server.flutter.SISP.controller.interfaces.IUserController;
import com.SISP.server.flutter.SISP.costants.Endpoint;
import com.SISP.server.flutter.SISP.entity.User;
import com.SISP.server.flutter.SISP.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(Endpoint.USER)
public class UserController implements IUserController {


    @Autowired
    UserService userService;

    public List<User> getUser(){
        return userService.getUser();
    }

    public void insertUser(@RequestBody User user){
        userService.insertUser(user);
    }
}
