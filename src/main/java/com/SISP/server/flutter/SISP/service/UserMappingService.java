package com.SISP.server.flutter.SISP.service;

import com.SISP.server.flutter.SISP.dto.UserDto;
import com.SISP.server.flutter.SISP.entity.Cart;
import com.SISP.server.flutter.SISP.entity.User;
import com.SISP.server.flutter.SISP.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserMappingService {
    @Autowired
    private UserRepository userRepository;

    private UserDto convertDataIntoDTO(User user) {
        UserDto dto = new UserDto();

        dto.setName(user.getName());

        Cart cart = new Cart();
        dto.setId_cart(cart.getId());
        return dto;
    }

    public List<UserDto> getAllUsersCart() {
        return ((List<User>) userRepository
                .findAll())
                .stream()
                .map(this::convertDataIntoDTO)
                .collect(Collectors.toList());
    }



}
