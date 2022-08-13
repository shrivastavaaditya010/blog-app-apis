package com.mycode.demo.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mycode.demo.entities.User;

public interface UserRepo extends JpaRepository<User, Integer> {
	Optional<User> findByEmail(String email);
}
