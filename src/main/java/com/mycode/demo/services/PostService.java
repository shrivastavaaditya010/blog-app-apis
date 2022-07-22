package com.mycode.demo.services;

import java.util.List;

import com.mycode.demo.entities.Post;
import com.mycode.demo.payloads.PostDto;

public interface PostService {

	//Create 
	PostDto createPost(PostDto postDto, Integer userId, Integer catagoryId);
	
	//Update
	PostDto updatePost(PostDto postDto, Integer postId);
	
	//Delete
	void deletePost(Integer postId);
	
	//Get all Posts
	List<Post>getAllPost();
	
	//Get single post
	Post getPostById(Integer postId);
	
	//Get All posts by Catagory
	List<Post> getPostByCatagory(Integer catagoryId);
	
	//Get All posts by User
	List<Post> getPostByUser(Integer userId);
	
	//Search post
	List<Post> searchPost(String keyword);
	
}
