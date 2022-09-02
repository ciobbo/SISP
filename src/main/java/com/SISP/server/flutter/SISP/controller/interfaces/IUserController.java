package com.SISP.server.flutter.SISP.controller.interfaces;

import com.SISP.server.flutter.SISP.entity.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


public interface IUserController {

    @GetMapping(value = "/getuser")
    public List<User> getUser();

    @PostMapping(value="/adduser")
    public String addUser(User NewUser);

    @PutMapping(value="/updateuse/{id}")
    public Optional<User> updateUser(String name, Long id) throws Exception;

    @GetMapping(value="/test/{id}")
    public Optional<User>test(Long id);

    @DeleteMapping(value = "/deleteuser/{id}")
    public String deleteUser(Long id);

    @PutMapping(value = "/deleteuserlogica/{id}")
    public String deleteUserLogica(Long id) throws Exception;

    @GetMapping(value = "/findflag")
    public List<User> findAllAndFlag();
}
