package com.dipaz.spring.user.service.user.service.repository;

import com.dipaz.spring.user.service.user.service.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByActive(boolean active);
    List<User> findByEmailContainingIgnoreCase(String email);
}
