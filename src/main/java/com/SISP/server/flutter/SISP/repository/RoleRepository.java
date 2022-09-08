package com.SISP.server.flutter.SISP.repository;

import com.SISP.server.flutter.SISP.security.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    public Role findRoleByName(String name);
    public Role saveRole (Role role);
}
