package com.SISP.server.flutter.SISP.controller;

import com.SISP.server.flutter.SISP.controller.interfaces.UserController;
import com.SISP.server.flutter.SISP.entity.User;
import com.SISP.server.flutter.SISP.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import static com.SISP.server.flutter.SISP.costants.Endpoint.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(USER)
public class UserControllerImpl implements UserController {


    @Autowired
    UserServiceImpl userService;


    @Override
    public List<User> getUser() {
        return userService.getUser();
    }

    @Override
    public String addUser(@RequestBody User NewUser){
        userService.saveUser(NewUser);
        return "New User!";
    }

    @Override
    public Optional<User> updateUser(@RequestBody String name, @PathVariable Long id) throws Exception {
        userService.updateuser(id, name);
        return userService.getuserbyid(id);
    }

    @Override
    public Optional<User> test (@PathVariable Long id){
        return userService.getuserbyid(id);
    }

    @Override
    public String deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return "Deleted user!";
    }

    @Override
    public String deleteUserLogica(@PathVariable  Long id) throws Exception {
        userService.deleteUserLogica(id);
        return "Deleted User!";
    }

    @Override
    public List<User> findAllAndFlag() {
        return userService.findAllAndFlag();
    }
}
