package com.SISP.server.flutter.SISP.repository;


import com.SISP.server.flutter.SISP.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    @Query(
            value = "SELECT * " +
                    "FROM USERS_SISP " +
                    "WHERE flag_deleted = 0",
            nativeQuery = true)
    List<User> getAllActiveUsers();

    @Query(
            value = "SELECT * " +
                    "FROM USERS_SISP " +
                    "WHERE flag_deleted = 1",
            nativeQuery = true)
    List<User> getAllNotActiveUsers();

}