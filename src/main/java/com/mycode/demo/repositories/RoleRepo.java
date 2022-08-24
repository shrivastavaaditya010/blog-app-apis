package com.mycode.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mycode.demo.entities.Role;

public interface RoleRepo extends JpaRepository<Role, Integer> {

}
