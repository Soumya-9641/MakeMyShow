package com.oauthorize.authorization.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oauthorize.authorization.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
