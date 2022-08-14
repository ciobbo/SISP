package com.SISP.server.flutter.SISP.controller.interfaces;

import static com.SISP.server.flutter.SISP.costants.Endpoint.*;
import com.SISP.server.flutter.SISP.entity.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;



public interface IUserController {

    @GetMapping
    List<User> getUser();

    @PostMapping(INSERT)
    void insertUser(@RequestBody User user);

    @PutMapping(DELETE + ID)
    void deleteUser(@RequestParam Integer id) throws Exception;
}
