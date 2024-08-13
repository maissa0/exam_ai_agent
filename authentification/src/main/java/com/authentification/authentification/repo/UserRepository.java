package com.authentification.authentification.repo;

import com.authentification.authentification.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {

    public User findByEmail(String email);
}
