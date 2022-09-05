package com.SISP.server.flutter.SISP.repository;

import com.SISP.server.flutter.SISP.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository <User, Long>{

    public List<User> findAll();
    public Optional<User> findById(Long id);
    public List<User> findAllByFlagDeleted(int flag);
}
