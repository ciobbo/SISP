package com.SISP.server.flutter.SISP.controller.interfaces;

import com.SISP.server.flutter.SISP.dto.CartDto;
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

    @PostMapping(value= "/create-new-cart")
    public Cart createCart();

    @GetMapping(value = "/get-cart/{id}")
    public Optional<Cart> getcart(@PathVariable Long id);

    @PutMapping(value = "/update-flag/{id}")
    public Cart updateFlag(@PathVariable Long id) throws Exception;

    @PutMapping("/add-product-to-cart/{cartId}/product")
    Cart addProductToCart(@PathVariable Long cartId, @RequestParam String name, @RequestBody Integer quantity) throws Exception;

    @GetMapping(value = "/map")
    public List<CartDto> getAllCartproductgetAllCartProduct();

}
