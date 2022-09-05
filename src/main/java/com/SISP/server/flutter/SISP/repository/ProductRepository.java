package com.SISP.server.flutter.SISP.repository;

import com.SISP.server.flutter.SISP.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    public List<Product> findAll();
    public Optional<Product> findById(Long id);
}
