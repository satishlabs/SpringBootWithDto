package com.satishlabs.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.satishlabs.exception.ResourceNotFoundException;
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

	@Override
	public Post createPost(Post post) {
		return postRepository.save(post);
	}

	@Override
	public Post updatePost(long id, Post postRequest) {
		//() -> new ResourceNotFoundException("Post","id",id)
		Post post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post","id",id));
		
		post.setTitle(postRequest.getTitle());
		post.setDescription(postRequest.getDescription());
		post.setContent(postRequest.getContent());
		return postRepository.save(post);
	}

}
