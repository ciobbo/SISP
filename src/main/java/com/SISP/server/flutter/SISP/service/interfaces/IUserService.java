package com.SISP.server.flutter.SISP.service.interfaces;

import com.SISP.server.flutter.SISP.entity.User;

import java.util.List;

public interface IUserService {

     List<User> getUser();
     void insertUser(User user);

     void deleteUser(Integer id) throws Exception;

     List<User> getAllActiveUser();

     List<User> getAllNotActiveUser();
}
