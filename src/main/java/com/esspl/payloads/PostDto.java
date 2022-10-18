package com.esspl.payloads;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.esspl.models.Comment;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PostDto {

	private Integer postId;
	private String title;
	private String content;
	private String imageName;
	private Date addedDate;
	private CategoryDto category;
	private UserDto user;
	private Set<CommentDto> comments=new HashSet<>();
	//why my infinite loop is not working and shows me a jackson databind error for below code- 
	/*
	 * private Category category; private User user;
	 */
}
