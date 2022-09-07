package com.SISP.server.flutter.SISP.controller;

import com.SISP.server.flutter.SISP.dto.CartDto;
import com.SISP.server.flutter.SISP.service.interfaces.CartMappingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class CartMappinController {
    @Autowired
    private CartMappingService cartmappingService;

    @GetMapping(value = "/cart/map")
    public List<CartDto> getAllCartproductgetAllCartProduct() {

        List <CartDto> cartproducts = cartmappingService.getAllCartProduct();
        return cartproducts;
    }
}
