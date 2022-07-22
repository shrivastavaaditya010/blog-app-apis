package com.mycode.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mycode.demo.entities.Catagory;
import com.mycode.demo.entities.Post;
import com.mycode.demo.entities.User;

public interface PostRepo extends JpaRepository<Post, Integer> {

	List<Post> findByUser(User user);
	List<Post> findByCatagory(Catagory catagory);
}
