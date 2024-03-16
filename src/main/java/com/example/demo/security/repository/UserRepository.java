package com.example.demo.security.repository;

import com.example.demo.security.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    //email uniqe ondan maille buluyoruz
    Optional<User> findByEmail(String email);
}
