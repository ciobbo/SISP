package com.SISP.server.flutter.SISP.controller.interfaces;

import com.SISP.server.flutter.SISP.entity.Product;
import static com.SISP.server.flutter.SISP.costants.Endpoint.*;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(PRODUCT)
public interface ProductController {

    @GetMapping(value = "/getproduct")
    public List<Product> getproducts();

    @PostMapping(value = "/addproduct")
    public Product addProduct (@RequestBody Product addProduct);

    @DeleteMapping(value = "/deleteproduct/{id}")
    public String deleteProduct (Long id);

    @GetMapping(value = "/getproduct/{id}")
    public Optional<Product> getProduct (Long id);

    @PutMapping(value = "/update/{id}")
    public Optional<Product> updateProduct(Long id, @RequestBody String name) throws Exception;
}
