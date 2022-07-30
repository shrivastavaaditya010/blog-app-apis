package com.mycode.demo.services;

import java.util.List;

import com.mycode.demo.entities.Post;
import com.mycode.demo.payloads.PostDto;
import com.mycode.demo.payloads.PostResponse;

public interface PostService {

	//Create 
	PostDto createPost(PostDto postDto, Integer userId, Integer catagoryId);
	
	//Update
	PostDto updatePost(PostDto postDto, Integer postId);
	
	//Delete
	void deletePost(Integer postId);
	
	//Get all Posts
	 PostResponse getAllPost(Integer pageNumber, Integer pageSize, String sortBy, String sortDir);
	
	//Get single post
	PostDto getPostById(Integer postId);
	
	//Get All posts by Catagory
	List<PostDto> getPostByCatagory(Integer catagoryId);
	
	//Get All posts by User
	List<PostDto> getPostByUser(Integer userId);
	
	//Search post
	List<Post> searchPost(String keyword);
	
}
