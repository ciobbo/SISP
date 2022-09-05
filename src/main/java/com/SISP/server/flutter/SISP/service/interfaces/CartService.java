package com.SISP.server.flutter.SISP.service.interfaces;

import com.SISP.server.flutter.SISP.entity.Cart;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public interface CartService {
    public List<Cart> getCarts();
    public Cart addCart(@RequestBody Cart addcart);
    public Cart getCart(Long id);
}
