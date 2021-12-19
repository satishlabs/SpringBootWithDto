package com.satishlabs.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.satishlabs.dto.PostDto;
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
}
