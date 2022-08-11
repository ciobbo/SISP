package com.SISP.server.flutter.SISP.controller.interfaces;

import com.SISP.server.flutter.SISP.costants.Endpoint;
import com.SISP.server.flutter.SISP.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface IUserController {

    @GetMapping
    List<User> getUser();

    @PostMapping(Endpoint.INSERT)
    void insertUser(@RequestBody User user);
}
