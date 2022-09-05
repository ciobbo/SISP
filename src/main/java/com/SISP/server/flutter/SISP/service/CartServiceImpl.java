package com.SISP.server.flutter.SISP.service;

import com.SISP.server.flutter.SISP.entity.Cart;
import com.SISP.server.flutter.SISP.repository.CartRepository;
import com.SISP.server.flutter.SISP.service.interfaces.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;
import java.util.Optional;

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
    public Optional<Cart> getCart(Long id) {
        return cartRepository.findById(id);
    }

    @Override
    public Cart updateFlag(@PathVariable Long id) throws Exception{
        Cart updateFlag = cartRepository.findById(id).orElseThrow(()->new Exception("Not Found Id"));
        updateFlag.setFlag_Status("D");
        return cartRepository.save(updateFlag);
    }



}
