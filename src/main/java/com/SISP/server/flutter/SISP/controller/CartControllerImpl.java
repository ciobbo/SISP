package com.SISP.server.flutter.SISP.controller;

import com.SISP.server.flutter.SISP.controller.interfaces.CartController;
import com.SISP.server.flutter.SISP.dto.CartDto;
import com.SISP.server.flutter.SISP.entity.Cart;
import com.SISP.server.flutter.SISP.repository.CartRepository;
import com.SISP.server.flutter.SISP.repository.ProductRepository;
import com.SISP.server.flutter.SISP.repository.UserRepository;
import com.SISP.server.flutter.SISP.service.CartServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
public class CartControllerImpl implements CartController {

    @Autowired
    private CartServiceImpl cartServiceImpl;

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<Cart> getCarts() {
        return cartServiceImpl.getCarts();
    }

    @Override
    public Cart createCart() {
        return cartServiceImpl.createCart();
    }

    @Override
    public Optional<Cart> getcart(Long id) {
        return cartServiceImpl.getCart(id);
    }

    @Override
    public Cart updateFlag(Long id) throws Exception {
        return cartServiceImpl.updateFlag(id);
    }

    @Override
    public Cart addProductToCart(Long cartId, String name, Integer quantity) throws Exception {
            return cartServiceImpl.addProductToCart(cartId, name, quantity);
    }

    @Override
    public List<CartDto> getAllCartproductgetAllCartProduct() {

        List <CartDto> cartproducts = cartServiceImpl.getAllCartProduct();
        return cartproducts;
    }
}
