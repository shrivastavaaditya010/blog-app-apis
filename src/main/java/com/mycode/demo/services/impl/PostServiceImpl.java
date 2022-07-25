package com.mycode.demo.services.impl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycode.demo.entities.Catagory;
import com.mycode.demo.entities.Post;
import com.mycode.demo.entities.User;
import com.mycode.demo.exceptions.ResourceNotFoundException;
import com.mycode.demo.payloads.CatagoryDto;
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
		Post post = this.postRepo.findById(postId).orElseThrow(()->new ResourceNotFoundException("post", "post", postId));
		post.setTitle(postDto.getTitle());
		post.setContent(postDto.getContent());
		post.setImageName(postDto.getImageName());
		Post updatedPost=this.postRepo.save(post);
		return this.modelMapper.map(updatedPost, PostDto.class);
		
	}

	@Override
	public void deletePost(Integer postId) {
		Post post = this.postRepo.findById(postId).orElseThrow(()->new ResourceNotFoundException("Post", "PostId", postId));
		this.postRepo.delete(post);
	}

	@Override
	public List<PostDto> getAllPost() {
		List<Post> post = this.postRepo.findAll();
		List<PostDto> postDtos = post.stream().map((posts) -> this.modelMapper.map(posts, PostDto.class))
				.collect(Collectors.toList());
		return postDtos;
	}

	@Override
	public PostDto getPostById(Integer postId) {
		Post post = this.postRepo.findById(postId).orElseThrow(()->new ResourceNotFoundException("Post", "PostId", postId));
		return this.modelMapper.map(post, PostDto.class);
	}

	@Override
	public List<PostDto> getPostByCatagory(Integer catagoryId) {
		Catagory cat=this.catagoryRepo.findById(catagoryId).orElseThrow(()->new ResourceNotFoundException("Catagory", "CatagoryId", catagoryId));
		List<Post> posts = this.postRepo.findByCatagory(cat);
		List<PostDto> postDtos = posts.stream().map((post)-> this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
		return postDtos;
	}

	@Override
	public List<PostDto> getPostByUser(Integer userId) {
		User user = this.userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User", "userId", userId));
		List<Post> posts = this.postRepo.findByUser(user);
		List<PostDto> postDtos = posts.stream().map((post)->this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
		return postDtos;
	}

	@Override
	public List<Post> searchPost(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

}
