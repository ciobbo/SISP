package com.SISP.server.flutter.SISP.service.interfaces;

import com.SISP.server.flutter.SISP.dto.CartDto;

import com.SISP.server.flutter.SISP.dto.UserDto;
import com.SISP.server.flutter.SISP.entity.Cart;
import com.SISP.server.flutter.SISP.entity.User;
import com.SISP.server.flutter.SISP.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CartMappingService {
    @Autowired
    private CartRepository cartRepository;

    private CartDto convertDataIntoDTO(Cart cart) {
        CartDto dto = new CartDto();

        dto.setId_cart(cart.getId());
        dto.setAddedProducts(cart.getAddedProducts());

        return dto;
    }


    public List<CartDto> getAllCartProduct() {
        return ((List<Cart>) cartRepository
                .findAll())
                .stream()
                .map(this::convertDataIntoDTO)
                .collect(Collectors.toList());
    }
}
