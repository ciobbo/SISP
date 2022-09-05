package com.SISP.server.flutter.SISP.service.interfaces;

import com.SISP.server.flutter.SISP.entity.Product;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ProductService {
    public List<Product> getproducts();
    public Product addProduct (Product addProduct);
    public void deleteProduct (Long id);
    public Optional<Product> getProduct(Long id);
    public void updateProduct(Long id, String name) throws Exception;
}
