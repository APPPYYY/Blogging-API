package com.esspl.services;

import java.util.List;

import com.esspl.payloads.PostDto;
import com.esspl.payloads.PostResponse;

public interface PostService {

	//create
	PostDto createPost(PostDto postDto,Integer userId,Integer categoryId);
	//update
	PostDto updatePost(PostDto postDto,Integer postId);
	//delete
	void deletePost(Integer postId);
	//getById
	PostDto getByPostId(Integer postId);
	//getAll
	PostResponse getAllPost(Integer pageNumber,Integer pageSize,String sortBy,String sortDir);
	//getByCategoryId
	List<PostDto> getByCategoryId(Integer categoryId);
	//getByUserId
	List<PostDto> getByUserId(Integer userId);
	//search
	List<PostDto> searchPosts(String keyword);
	
	
	
}
