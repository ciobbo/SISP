package com.SISP.server.flutter.SISP.service;

import com.SISP.server.flutter.SISP.repository.UserRepository;
import com.SISP.server.flutter.SISP.entity.User;
import com.SISP.server.flutter.SISP.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public List<User> getUser() {
        return userRepository.findAll();
    }

    @Override
    public void saveUser(User NewUser) {
        userRepository.save(NewUser);
    }

    @Override
    public Optional<User> getuserbyid(Long id){
        return userRepository.findById(id);
    }

    @Override
    public void updateuser(Long id, String name) throws Exception {
       User updateUser = userRepository.findById(id).orElseThrow(()-> new Exception("user not found"));
       updateUser.setName(name);
       userRepository.save(updateUser);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public void deleteUserLogica(Long id) throws Exception {
        User deleteUser = userRepository.findById(id).orElseThrow(()-> new Exception("user not found"));
        deleteUser.setFlagDeleted(1);
        userRepository.save(deleteUser);
    }

    @Override
    public List<User> findAllAndFlag() {
        return userRepository.findAllByFlagDeleted(1);
    }


}