package com.example.task5.repos;

import com.example.task5.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
    User deleteByUsername(String username);
}
