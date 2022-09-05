package com.SISP.server.flutter.SISP.controller.interfaces;

import com.SISP.server.flutter.SISP.entity.Cart;
import static com.SISP.server.flutter.SISP.costants.Endpoint.*;

import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(CART)
public interface CartController {

    @GetMapping(value = "/get-carts")
    public List<Cart> getCarts();

    @PostMapping(value= "/add-cart")
    public Cart addCart(@RequestBody Cart addCart);

    @GetMapping(value = "/get-cart/{id}")
    public Optional<Cart> getcart(@PathVariable Long id);

    @PutMapping(value = "/update-flag/{id}")
    public Cart updateFlag(@PathVariable Long id) throws Exception;


}
