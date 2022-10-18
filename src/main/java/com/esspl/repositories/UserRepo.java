package com.esspl.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.esspl.models.User;

public interface UserRepo extends JpaRepository<User, Integer>{

	Optional<User> findByEmail(String username);
	
}
