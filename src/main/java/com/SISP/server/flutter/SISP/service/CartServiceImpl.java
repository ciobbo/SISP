package com.SISP.server.flutter.SISP.service;

import com.SISP.server.flutter.SISP.costants.Utility;
import com.SISP.server.flutter.SISP.dto.CartDto;
import com.SISP.server.flutter.SISP.entity.*;
import com.SISP.server.flutter.SISP.repository.*;
import com.SISP.server.flutter.SISP.service.interfaces.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    ProductRepository productRepository;

    Utility utils = new Utility();

    CartDto cartDto = new CartDto();


    @Override
    public List<Cart> getCarts() {
        return cartRepository.findAll();
    }

    @Override
    public Cart createCart() {
        Cart cartToAdd = new Cart();
        cartToAdd.setDate(utils.generateCurrentDate());
        cartToAdd.setFlag_Status("C");

        return cartRepository.save(cartToAdd);
    }

    @Override
    public Optional<Cart> getCart(Long id) {
        return cartRepository.findById(id);
    }

    @Override
    public Cart updateFlag(@PathVariable Long id) throws Exception{
        Cart updateFlag = cartRepository
                .findById(id)
                .orElseThrow(()->new Exception("Not Found Id"));
        updateFlag.setFlag_Status("D");
        return cartRepository.save(updateFlag);
    }

    @Override
    public Cart addProductToCart(Long cartId, String name, Integer quantity) throws Exception {

        Cart cart = cartRepository
                .findById(cartId)
                .orElseThrow(() -> new Exception("Not Found Cart"));

        if (cart.getFlag_Status().equals("D")){
            throw new Exception("Cart deleted");
        }else {
            Product product = productRepository.findByProductName(name);
            product.setQuantity(quantity);
            cart.addProduct(product);
            return cartRepository.save(cart);
        }
    }

    public List<CartDto> getAllCartProduct() {
        return ((List<Cart>) cartRepository
                .findAll())
                .stream()
                .map(cart-> cartDto.convertDataIntoDTO(cart))
                .collect(Collectors.toList());
    }



}
