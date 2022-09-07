package com.SISP.server.flutter.SISP.controller;

import com.SISP.server.flutter.SISP.dto.UserDto;
import com.SISP.server.flutter.SISP.service.UserMappingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserMappingController {
    @Autowired
    private UserMappingService mappingService;

    @GetMapping(value = "/map")
    public List<UserDto> getAllUsersCartgetAllUsersCart() {

        List <UserDto> usersLocation = mappingService.getAllUsersCart();
        return usersLocation;
    }
}
