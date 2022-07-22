package com.mycode.demo.services.impl;

import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycode.demo.entities.Catagory;
import com.mycode.demo.entities.Post;
import com.mycode.demo.entities.User;
import com.mycode.demo.exceptions.ResourceNotFoundException;
import com.mycode.demo.payloads.PostDto;
import com.mycode.demo.repositories.CatagoryRepo;
import com.mycode.demo.repositories.PostRepo;
import com.mycode.demo.repositories.UserRepo;
import com.mycode.demo.services.PostService;

@Service
public class PostServiceImpl implements PostService {

	@Autowired
	private PostRepo postRepo;

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private CatagoryRepo catagoryRepo;

	@Override
	public PostDto createPost(PostDto postDto, Integer userId, Integer catagoryId) {

		User user = this.userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "userId", userId));
		
		Catagory catagory = this.catagoryRepo.findById(catagoryId)
				.orElseThrow(() -> new ResourceNotFoundException("Catagory", "catagoryId", catagoryId));

		Post post = this.modelMapper.map(postDto, Post.class);
		post.setImageName("default.png");
		post.setAddedDate(new Date());
		post.setUser(user);
		post.setCatagory(catagory);
		
		Post newPost = this.postRepo.save(post);
		return this.modelMapper.map(newPost, PostDto.class);
	}

	@Override
	public PostDto updatePost(PostDto postDto, Integer postId) {
		// TODO Auto-generated method stub
	return null;
	}

	@Override
	public void deletePost(Integer postId) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Post> getAllPost() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Post getPostById(Integer postId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Post> getPostByCatagory(Integer catagoryId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Post> getPostByUser(Integer userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Post> searchPost(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

}
