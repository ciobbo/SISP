package com.SISP.server.flutter.SISP.controller;

import com.SISP.server.flutter.SISP.controller.interfaces.UserController;
import com.SISP.server.flutter.SISP.dto.UserDto;
import com.SISP.server.flutter.SISP.repository.RoleRepository;
import com.SISP.server.flutter.SISP.security.Role;
import com.SISP.server.flutter.SISP.security.User;
import com.SISP.server.flutter.SISP.service.UserServiceImpl;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import static com.SISP.server.flutter.SISP.costants.Endpoint.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(USER)
public class UserControllerImpl implements UserController {

    @Autowired
    UserServiceImpl userServiceImpl;

    @Autowired
    RoleRepository roleRepository;

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

    @Override
    public ResponseEntity<Role> saveRole(@RequestBody Role role) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/controller/add-role/").toUriString());
        return ResponseEntity.created(uri).body(userServiceImpl.saveRole(role));
    }

    @Override
    public ResponseEntity<?> addRoleToUser(RoleToUserForm form) {
         userServiceImpl.addRoleToUser(form.getUsername(), form.getRoleName()) ;
        return ResponseEntity.ok().build();
    }
}

