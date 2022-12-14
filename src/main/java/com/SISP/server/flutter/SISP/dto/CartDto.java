package com.SISP.server.flutter.SISP.dto;

import com.SISP.server.flutter.SISP.entity.Cart;
import com.SISP.server.flutter.SISP.entity.Product;
import lombok.Getter;
import lombok.Setter;


import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class CartDto {
    private Long id_cart;

    private Set<Product> addedProducts = new HashSet<>();


    public CartDto convertDataIntoDTO(Cart cart) {
        CartDto cartDto = new CartDto();

        cartDto.setId_cart(cart.getId());
        cartDto.setAddedProducts(cart.getAddedProducts());

        return cartDto;
    }


}
