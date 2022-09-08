package com.SISP.server.flutter.SISP.service;

import com.SISP.server.flutter.SISP.dto.UserDto;
import com.SISP.server.flutter.SISP.repository.RoleRepository;
import com.SISP.server.flutter.SISP.repository.UserRepository;
import com.SISP.server.flutter.SISP.security.Role;
import com.SISP.server.flutter.SISP.security.User;
import com.SISP.server.flutter.SISP.service.interfaces.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;


    UserDto userDto = new UserDto();

    @Override
    public Role saveRole(Role role) {
        return roleRepository.saveRole(role);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        User user = userRepository.findUserByName(username);
        Role role = roleRepository.findRoleByName(roleName);
        user.getRoles().add(role);
    }

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

    @Override
    public List<UserDto> getAllUsersCart() {
        return ((List<User>) userRepository
                .findAll())
                .stream()
                .map(user -> userDto.convertDataIntoDTO(user))
                .collect(Collectors.toList());
    }
}