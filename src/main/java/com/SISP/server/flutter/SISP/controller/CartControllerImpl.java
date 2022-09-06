package com.SISP.server.flutter.SISP.controller;

import com.SISP.server.flutter.SISP.controller.interfaces.CartController;
import com.SISP.server.flutter.SISP.entity.Cart;
import com.SISP.server.flutter.SISP.entity.Product;
import com.SISP.server.flutter.SISP.entity.User;
import com.SISP.server.flutter.SISP.repository.CartRepository;
import com.SISP.server.flutter.SISP.repository.ProductRepository;
import com.SISP.server.flutter.SISP.repository.UserRepository;
import com.SISP.server.flutter.SISP.service.CartServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;


@RestController
public class CartControllerImpl implements CartController {
    @Autowired
    private CartServiceImpl cartService;

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ProductRepository productRepository;


    @Autowired
    private UserRepository userRepository;



    @Override
    public List<Cart> getCarts() {
        return cartService.getCarts();
    }

    @Override
    public Cart createCart() {
        return cartService.createCart();
    }

    @Override
    public Optional<Cart> getcart(Long id) {
        return cartService.getCart(id);
    }

    @Override
    public Cart updateFlag(Long id) throws Exception {
        return cartService.updateFlag(id);
    }

    @Override
    public Cart addProductToCart(@PathVariable Long cartId, @RequestParam String name, @RequestBody Integer quantity) throws Exception {
            return cartService.addProductToCart(cartId, name, quantity);
    }
}
