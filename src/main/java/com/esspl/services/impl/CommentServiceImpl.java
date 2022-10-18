/**
 * 
 */
package com.esspl.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esspl.exceptions.ResourceNotFoundException;
import com.esspl.models.Comment;
import com.esspl.models.Post;
import com.esspl.payloads.CommentDto;
import com.esspl.repositories.CommentRepo;
import com.esspl.repositories.PostRepo;
import com.esspl.services.CommentService;

/**
 * @author subhamb
 *
 */
@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private PostRepo postRepo;
	@Autowired
	private CommentRepo commentRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public CommentDto createComment(CommentDto commentDto,Integer postId) {
		Post post=this.postRepo.findById(postId).orElseThrow(()->new ResourceNotFoundException("Post", "post id :", postId));
		Comment comment=this.modelMapper.map(commentDto, Comment.class);
		comment.setPost(post);
		Comment createdComment=this.commentRepo.save(comment);
		return this.modelMapper.map(createdComment, CommentDto.class);
	}

	@Override
	public void deleteComment(Integer commentId) {
		Comment comment=this.commentRepo.findById(commentId).orElseThrow(()->new ResourceNotFoundException("Comment", "comment id :", commentId));
		this.commentRepo.delete(comment);

	}

}
