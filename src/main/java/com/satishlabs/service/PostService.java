package com.satishlabs.service;

import java.util.List;

import com.satishlabs.model.Post;

public interface PostService {
	List<Post> getAllPosts();
	
	Post createPost(Post post);
	
	Post updatePost(long id,Post post);
}
