package com.mycode.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mycode.demo.entities.Comment;

public interface CommentRepo extends JpaRepository<Comment, Integer>{

}
