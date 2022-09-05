package com.SISP.server.flutter.SISP.service.interfaces;

import com.SISP.server.flutter.SISP.entity.Cart;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public interface CartService {
    public List<Cart> getCarts();
    public Cart addCart(@RequestBody Cart addcart);
    public Optional<Cart> getCart(Long id);
    public Cart updateFlag (Long id) throws Exception;
}
