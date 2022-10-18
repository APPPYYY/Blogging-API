package com.esspl.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.esspl.models.Comment;

public interface CommentRepo extends JpaRepository<Comment,Integer> {

}
