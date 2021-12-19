package com.satishlabs.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.satishlabs.dto.PostDto;
import com.satishlabs.model.Post;
import com.satishlabs.service.PostService;

@RestController
public class PostController {
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private PostService postService;
	
	@GetMapping("/getPost")
	public List<PostDto> getAllPosts(){
		return postService.getAllPosts().stream().map(post -> modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
	}
	
	@PostMapping("/createPost")
	public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto){
		//Convert DTO to entity
		
		Post postRequest = modelMapper.map(postDto, Post.class);
		
		Post post =  postService.createPost(postRequest);
		
		//Convert entity to DTO
		PostDto postResponse = modelMapper.map(post, PostDto.class);
		
		return new ResponseEntity<PostDto>(postResponse,HttpStatus.CREATED);
	}
	
	@PutMapping("/updatePost/{id}")
	public ResponseEntity<PostDto> updatePost(@PathVariable long id,@RequestBody PostDto postDto){
		
		//Convert DTO to entity
		Post postRequest = modelMapper.map(postDto, Post.class);
		
		Post post = postService.updatePost(id, postRequest);
		
		//Entity to DTO
		
		PostDto postResponse = modelMapper.map(post, PostDto.class);
		
		return ResponseEntity.ok().body(postResponse);
		
	}
	
}
