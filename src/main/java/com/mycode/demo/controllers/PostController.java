package com.mycode.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mycode.demo.entities.Post;
import com.mycode.demo.payloads.PostDto;
import com.mycode.demo.services.PostService;

@RestController
@RequestMapping("/api/")
public class PostController {

	@Autowired
	private PostService postService;

	// Create
	@PostMapping("/user/{userId}/catagory/{catagoryId}/posts")
	public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto, @PathVariable Integer userId,
			@PathVariable Integer catagoryId) {
		PostDto createPost = this.postService.createPost(postDto, userId, catagoryId);
		return new ResponseEntity<PostDto>(createPost, HttpStatus.CREATED);
	}
}
