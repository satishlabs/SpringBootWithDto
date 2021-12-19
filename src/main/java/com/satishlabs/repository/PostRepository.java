package com.satishlabs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.satishlabs.model.Post;

public interface PostRepository extends JpaRepository<Post, Long>{

}
