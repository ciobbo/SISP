package com.SISP.server.flutter.SISP.service.interfaces;

import com.SISP.server.flutter.SISP.entity.User;

import java.util.List;
import java.util.Optional;

public interface IUserService {

    public List<User> getUser();
    public void saveUser(User NewUser);
    public Optional<User>getuserbyid(Long id);
    public void updateuser(Long id, String name)throws Exception;
    public void deleteUser(Long id);
    public void deleteUserLogica (Long id) throws Exception;
    public List<User> findAllAndFlag();
}
