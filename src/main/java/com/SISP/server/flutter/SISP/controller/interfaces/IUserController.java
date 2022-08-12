package com.SISP.server.flutter.SISP.controller.interfaces;

import com.SISP.server.flutter.SISP.costants.Endpoint;
import com.SISP.server.flutter.SISP.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import static com.SISP.server.flutter.SISP.costants.Endpoint.*;

public interface IUserController {

    @GetMapping
    List<User> getUser();

    @PostMapping(INSERT)
    void insertUser(@RequestBody User user);
}
