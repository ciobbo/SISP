package com.SISP.server.flutter.SISP.service;

import com.SISP.server.flutter.SISP.entity.Cart;
import com.SISP.server.flutter.SISP.repository.CartRepository;
import com.SISP.server.flutter.SISP.service.interfaces.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartRepository cartRepository;

    @Override
    public List<Cart> getCarts() {
        return cartRepository.findAll();
    }

    @Override
    public Cart addCart(@RequestBody Cart addcart) {
        return cartRepository.save(addcart);
    }

    @Override
    public Cart getCart(Long id) {
        return null;
    }


}
