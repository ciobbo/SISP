package com.SISP.server.flutter.SISP.dto;

import com.SISP.server.flutter.SISP.entity.Cart;
import com.SISP.server.flutter.SISP.entity.User;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class UserDto {

    private String name;

    private Long id_cart;

    public UserDto convertDataIntoDTO(User user) {
        UserDto dto = new UserDto();

        dto.setName(user.getName());

        Cart cart = new Cart();
        dto.setId_cart(cart.getId());
        return dto;
    }

}

