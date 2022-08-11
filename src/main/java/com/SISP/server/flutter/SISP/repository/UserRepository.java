package com.SISP.server.flutter.SISP.repository;


import com.SISP.server.flutter.SISP.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}