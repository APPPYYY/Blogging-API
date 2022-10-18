package com.esspl.rest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.esspl.payloads.ApiResponse;
import com.esspl.payloads.CommentDto;
import com.esspl.services.CommentService;

@RestController
@RequestMapping("/api/")
public class CommentController {

	@Autowired
	private CommentService commentService;
	
	
	
	@PostMapping("/posts/{postId}/comments")
	public ResponseEntity<CommentDto> createComment(
			@RequestBody CommentDto commentDto,
			@PathVariable Integer postId
			){
		CommentDto createdComment= this.commentService.createComment(commentDto, postId);
		return new ResponseEntity<>(createdComment,HttpStatus.CREATED);
	}
	
	
	
	@DeleteMapping("/comments/{commentId}")
	public ResponseEntity<ApiResponse> deleteComment(@PathVariable Integer commentId){
		this.commentService.deleteComment(commentId);
		return new ResponseEntity<>(new ApiResponse("__comeflywithme__","Comment successfully deleted !","Sorry ab kuch nehi"
				+ " kar sakte !!!",true),HttpStatus.NOT_FOUND);
	}
	
	
	
	
	
	
	
}
