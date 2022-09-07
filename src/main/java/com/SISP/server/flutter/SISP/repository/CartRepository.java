package com.SISP.server.flutter.SISP.repository;

import com.SISP.server.flutter.SISP.dto.CartDto;
import com.SISP.server.flutter.SISP.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {

    public List<Cart> findAll();
    public Optional<Cart> findById(Long id);
}
