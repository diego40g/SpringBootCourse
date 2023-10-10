package com.dipaz.spring.user.service.user.service.repository;

import java.util.List;
import com.dipaz.spring.user.service.user.service.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    List<User> findByAge(int age);

    List<User> findByFirstnameContainingIgnoreCase(String firstname);

}
