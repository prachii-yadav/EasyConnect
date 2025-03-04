package com.scm.scm20.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.scm.scm20.entities.User;

@Repository
public interface UserRepo extends JpaRepository<User, String> {
    // extra methods db related operations
    // custom query method
    // custom finder method

    Optional<User> findByEmail(String email);
}
