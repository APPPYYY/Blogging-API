package com.esspl.services;

import com.esspl.payloads.CommentDto;

public interface CommentService {

	CommentDto createComment(CommentDto commentDto,Integer postId);
	void deleteComment(Integer commentId);
}
