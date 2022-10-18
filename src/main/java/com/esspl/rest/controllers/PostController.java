package com.esspl.rest.controllers;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.hibernate.engine.jdbc.StreamUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.esspl.config.AppConstants;
import com.esspl.payloads.ApiResponse;
import com.esspl.payloads.PostDto;
import com.esspl.payloads.PostResponse;
import com.esspl.services.FileService;
import com.esspl.services.PostService;

@RestController
@RequestMapping("/api/")
public class PostController {

	@Autowired
	private PostService postService;
	@Autowired
	private FileService fileService;
	
	@Value("${project.image}")
	private String path;
	
	//create post
	
	@PostMapping("/user/{userId}/category/{categoryId}/posts")
	public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto,
			@PathVariable Integer userId,
			@PathVariable Integer categoryId)
	{
		PostDto createdPost=this.postService.createPost(postDto, userId, categoryId);
		return new ResponseEntity<>(createdPost,HttpStatus.CREATED);
		
	}
	
	//getByUser
	@GetMapping("/user/{userId}/posts")
	public ResponseEntity<List<PostDto>> getByUser(@PathVariable Integer userId){
		List<PostDto> posts=this.postService.getByUserId(userId);
		return new ResponseEntity<>(posts,HttpStatus.OK);
	}
	
	//getByCategory
	@GetMapping("/category/{categoryId}/posts")
	public ResponseEntity<List<PostDto>> getByCategory(@PathVariable Integer categoryId){
		List<PostDto> posts=this.postService.getByCategoryId(categoryId);
		return new ResponseEntity<>(posts,HttpStatus.OK);
	}
	
	//getAllPosts
	@GetMapping("/posts")
	public ResponseEntity<PostResponse> getAllPost(
			@RequestParam(value = "pageNumber",defaultValue =AppConstants.PAGE_NUMBER,required = false) Integer pageNumber,
			@RequestParam(value = "pageSize",defaultValue = AppConstants.PAGE_SIZE,required = false)Integer pageSize,
			@RequestParam(value = "sortBy",defaultValue = AppConstants.SORT_BY,required = false) String sortBy,
			@RequestParam(value = "sortDir",defaultValue = AppConstants.SORT_DIR,required = false) String sortDir
			){
		PostResponse postResponse=this.postService.getAllPost(pageNumber,pageSize,sortBy,sortDir);
		
		return new ResponseEntity<>(postResponse,HttpStatus.OK);
	}
	
	//getPostById
	@GetMapping("/posts/{postId}")
	public ResponseEntity<PostDto> getPostById(@PathVariable Integer postId){
		PostDto postDto=this.postService.getByPostId(postId);
		return new ResponseEntity<>(postDto,HttpStatus.OK);
	}
	
	//deletePost
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/posts/{postId}")
	public ResponseEntity<ApiResponse>deletePost(@PathVariable Integer postId){
		this.postService.deletePost(postId);
		return new ResponseEntity<>(new ApiResponse("__comeflywithme__","Post successfully deleted !","Sorry ab"
				+ " kuch nehi kar sakte !!!",true),HttpStatus.NOT_FOUND);
	}
	
	//updatePost
	@PutMapping("/posts/{postId}")
	public ResponseEntity<PostDto>updatePost(@RequestBody PostDto postDto,@PathVariable Integer postId){
		PostDto posts=this.postService.updatePost(postDto, postId);
		return new ResponseEntity<>(posts,HttpStatus.OK);
	}
	
	//searchPosts
	@GetMapping("/posts/search/{keyword}")
	public ResponseEntity<List<PostDto>> searchPosts(@PathVariable("keyword") String keyword){
		List<PostDto>result=this.postService.searchPosts(keyword);
		return new ResponseEntity<>(result,HttpStatus.OK);
	}
	
	//uploadImage
	@PostMapping("/posts/image/upload/{postId}")
	public ResponseEntity<PostDto> uploadImage(
			@RequestParam("image") MultipartFile image,
			@PathVariable Integer postId
			)throws IOException{
		String fileName=this.fileService.uploadImage(path, image);
		PostDto postDto=this.postService.getByPostId(postId);
		postDto.setImageName(fileName);
		PostDto result=this.postService.updatePost(postDto, postId);
		return new ResponseEntity<>(result,HttpStatus.OK);
		
	}
	
	//method to serve Files/Image
	@GetMapping(value = "/posts/image/{imageName}",produces = MediaType.IMAGE_JPEG_VALUE)
	public void downloadImage(
			@PathVariable("imageName") String imageName,
			HttpServletResponse response
			) throws IOException {
		InputStream resource=this.fileService.getResource(path, imageName);
		response.setContentType(MediaType.IMAGE_JPEG_VALUE);
		StreamUtils.copy(resource,response.getOutputStream());		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
