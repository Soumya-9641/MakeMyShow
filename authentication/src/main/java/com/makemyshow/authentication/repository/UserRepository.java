package com.makemyshow.authentication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.makemyshow.authentication.models.User;

@Repository

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
