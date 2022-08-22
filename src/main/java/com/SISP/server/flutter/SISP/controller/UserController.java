package com.SISP.server.flutter.SISP.controller;

import com.SISP.server.flutter.SISP.controller.interfaces.IUserController;
import com.SISP.server.flutter.SISP.entity.User;
import com.SISP.server.flutter.SISP.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import static com.SISP.server.flutter.SISP.costants.Endpoint.*;

import java.util.List;

@RestController
@RequestMapping(USER)
public class UserController implements IUserController {


    @Autowired
    UserService userService;

    @Override
    public List<User> getUser(){
        return userService.getUser();
    }

    @Override
    public List<User> getAllActiveUsers() {
        return userService.getAllActiveUser();
    }

    @Override
    public List<User> getAllNotActiveUsers() {
        return userService.getAllNotActiveUser();
    }

    @Override
    public void insertUser(@RequestBody User user){
        userService.insertUser(user);
    }

    @Override
    public String deleteUser(Long id) throws Exception {
        userService.deleteUser(id);
        return "user deleted";
    }

    @Override
    public User getUserById(Long id) throws Exception {
        return userService.getUserById(id);
    }


}
