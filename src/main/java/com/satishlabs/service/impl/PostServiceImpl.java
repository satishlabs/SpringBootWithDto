package com.satishlabs.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.satishlabs.model.Post;
import com.satishlabs.repository.PostRepository;
import com.satishlabs.service.PostService;

@Service
public class PostServiceImpl implements PostService{
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public List<Post> getAllPosts() {
		return postRepository.findAll();
	}

}
