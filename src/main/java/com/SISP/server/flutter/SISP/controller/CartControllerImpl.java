package com.SISP.server.flutter.SISP.controller;

import com.SISP.server.flutter.SISP.controller.interfaces.CartController;
import com.SISP.server.flutter.SISP.entity.Cart;
import com.SISP.server.flutter.SISP.service.CartServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class CartControllerImpl implements CartController {
    @Autowired
    private CartServiceImpl cartService;

    @Override
    public List<Cart> getCarts() {
        return cartService.getCarts();
    }

    @Override
    public Cart addCart(Cart addCart) {
        return cartService.addCart(addCart);
    }
}
