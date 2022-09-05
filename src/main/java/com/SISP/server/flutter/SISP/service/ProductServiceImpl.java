package com.SISP.server.flutter.SISP.service;

import com.SISP.server.flutter.SISP.entity.Product;
import com.SISP.server.flutter.SISP.repository.ProductRepository;

import com.SISP.server.flutter.SISP.service.interfaces.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {


    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getproducts() {
        return productRepository.findAll();
    }

    @Override
    public Product addProduct(Product addProduct) {
        return productRepository.save(addProduct);
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public Optional<Product> getProduct(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public void updateProduct(Long id, String name) throws Exception{
        Product updateProduct = productRepository.findById(id).orElseThrow(()->new Exception("Not Found Product!"));
        updateProduct.setProductName(name);
        productRepository.save(updateProduct);
    }


}
