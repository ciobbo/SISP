package com.SISP.server.flutter.SISP.controller;

import com.SISP.server.flutter.SISP.entity.Product;
import com.SISP.server.flutter.SISP.service.ProductServiceImpl;
import com.SISP.server.flutter.SISP.controller.interfaces.ProductController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

import static com.SISP.server.flutter.SISP.costants.Endpoint.PRODUCT;

@RestController
@RequestMapping(PRODUCT)
public class ProductControllerImpl implements ProductController {
    @Autowired
    private ProductServiceImpl productService;


    @Override
    public List<Product> getproducts() {
        return productService.getproducts();
    }

    @Override
    public Product addProduct(@RequestBody Product addProduct) {
        return productService.addProduct(addProduct);
    }

    @Override
    public String deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return "Deleted Product !";
    }

    @Override
    public Optional<Product> getProduct(@PathVariable Long id) {
        return productService.getProduct(id);
    }

    @Override
    public Optional<Product> updateProduct(@PathVariable Long id, @RequestBody  String name) throws Exception{
        productService.updateProduct(id, name);
        return productService.getProduct(id);
    }


}
