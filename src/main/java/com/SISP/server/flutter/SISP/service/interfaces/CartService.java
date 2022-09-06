package com.SISP.server.flutter.SISP.service.interfaces;

import com.SISP.server.flutter.SISP.entity.Cart;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface CartService {
    public List<Cart> getCarts();
    public Cart createCart();
    public Optional<Cart> getCart(Long id);
    public Cart updateFlag (Long id) throws Exception;
    Cart addProductToCart(Long cartId, String name, Integer quantity) throws Exception;
}
