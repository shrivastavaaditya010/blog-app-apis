package com.mycode.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mycode.demo.entities.Catagory;

public interface CatagoryRepo extends JpaRepository<Catagory, 	Integer> {

}
