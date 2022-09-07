package com.SISP.server.flutter.SISP.controller;

import com.SISP.server.flutter.SISP.controller.interfaces.UserController;
import com.SISP.server.flutter.SISP.dto.UserDto;
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
    UserServiceImpl userServiceImpl;


    @Override
    public List<User> getUser() {
        return userServiceImpl.getUser();
    }

    @Override
    public String addUser(@RequestBody User NewUser){
        userServiceImpl.saveUser(NewUser);
        return "New User!";
    }

    @Override
    public Optional<User> updateUser(@RequestBody String name, @PathVariable Long id) throws Exception {
        userServiceImpl.updateuser(id, name);
        return userServiceImpl.getuserbyid(id);
    }

    @Override
    public Optional<User> getUserById (@PathVariable Long id){
        return userServiceImpl.getuserbyid(id);
    }

    @Override
    public String deleteUser(@PathVariable Long id) {
        userServiceImpl.deleteUser(id);
        return "Deleted user!";
    }

    @Override
    public String deleteUserLogica(@PathVariable  Long id) throws Exception {
        userServiceImpl.deleteUserLogica(id);
        return "Deleted User!";
    }

    @Override
    public List<User> findAllAndFlag() {
        return userServiceImpl.findAllAndFlag();
    }

    @Override
    public List<UserDto> getAllUsersCartgetAllUsersCart() {
        List <UserDto> usersLocation = userServiceImpl.getAllUsersCart();
        return usersLocation;
    }
}
