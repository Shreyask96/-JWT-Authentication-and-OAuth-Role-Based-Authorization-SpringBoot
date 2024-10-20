package com.dakrsolutions.JWT_OAuth.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.dakrsolutions.JWT_OAuth.Entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
}

