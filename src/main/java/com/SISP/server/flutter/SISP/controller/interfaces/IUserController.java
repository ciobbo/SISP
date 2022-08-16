package com.SISP.server.flutter.SISP.controller.interfaces;

import static com.SISP.server.flutter.SISP.costants.Endpoint.*;
import com.SISP.server.flutter.SISP.entity.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;



public interface IUserController {

    @GetMapping
    List<User> getUser();

    @GetMapping(ACTIVE_USERS)
    List<User> getAllActiveUsers();

    @GetMapping(NOT_ACTIVE_USERS)
    List<User> getAllNotActiveUsers();

    @PostMapping(INSERT)
    void insertUser(@RequestBody User user);

    @PutMapping(DELETE + ID)
    String deleteUser(@PathVariable Integer id) throws Exception;


}
