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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @PutMapping("/{cartId}/product/{productId}")
    Cart addProductToCart(@PathVariable Long cartId, @PathVariable Long productId) throws Exception {
        Cart cart = cartService.getCart(cartId). orElseThrow(() -> new Exception("Not Found Cart"));
        if (cart.getFlag_Status().equals("D")){
            throw new Exception("Cart deleted");
        }else {
            Product product = productRepository.findById(productId).get();
            cart.addProduct(product);
            return cartRepository.save(cart);
        }
    }
}
