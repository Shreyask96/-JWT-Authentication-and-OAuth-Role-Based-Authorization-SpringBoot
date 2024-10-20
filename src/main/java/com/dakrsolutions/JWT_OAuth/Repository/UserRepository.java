package com.dakrsolutions.JWT_OAuth.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.dakrsolutions.JWT_OAuth.Entity.User;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
