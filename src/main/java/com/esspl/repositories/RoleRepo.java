package com.esspl.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.esspl.models.Role;

public interface RoleRepo extends JpaRepository<Role, Integer> {

}
