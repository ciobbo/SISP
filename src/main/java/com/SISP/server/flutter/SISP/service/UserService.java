package com.SISP.server.flutter.SISP.service;

import com.SISP.server.flutter.SISP.repository.UserRepository;
import com.SISP.server.flutter.SISP.entity.User;
import com.SISP.server.flutter.SISP.service.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getUser() {
        return userRepository.findAll();
    }

    public void insertUser(User user){
        userRepository.save(user);
    }
}
