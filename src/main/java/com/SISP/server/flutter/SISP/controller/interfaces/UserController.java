package com.SISP.server.flutter.SISP.controller.interfaces;

import com.SISP.server.flutter.SISP.controller.RoleToUserForm;
import com.SISP.server.flutter.SISP.controller.UserControllerImpl;
import com.SISP.server.flutter.SISP.dto.UserDto;
import com.SISP.server.flutter.SISP.security.Role;
import com.SISP.server.flutter.SISP.security.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


public interface UserController {

    @GetMapping(value = "/get-user")
    public List<User> getUser();

    @PostMapping(value = "/add-user")
    public String addUser(User NewUser);

    @PutMapping(value = "/update-use/{id}")
    public Optional<User> updateUser(String name, Long id) throws Exception;

    @GetMapping(value = "/get-user-by-id/{id}")
    public Optional<User> getUserById(Long id);

    @DeleteMapping(value = "/delete-user/{id}")
    public String deleteUser(Long id);

    @PutMapping(value = "/delete-user-logica/{id}")
    public String deleteUserLogica(Long id) throws Exception;

    @GetMapping(value = "/find-flag")
    public List<User> findAllAndFlag();

    @GetMapping(value = "/map")
    public List<UserDto> getAllUsersCartgetAllUsersCart();

    @PostMapping(value = "/add-role")
    public ResponseEntity<Role> saveRole(Role role);

    @PostMapping(value = "/add-role-to-user")
    public ResponseEntity<?> addRoleToUser(RoleToUserForm form);


}