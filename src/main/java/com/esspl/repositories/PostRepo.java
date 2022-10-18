package com.esspl.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.esspl.models.Category;
import com.esspl.models.Post;
import com.esspl.models.User;

public interface PostRepo extends JpaRepository<Post,Integer> {

	//find by user
	List<Post> findByUser(User user);
	//find by category
	List<Post> findByCategory(Category category);
	//search
	List<Post> findByTitleContaining(String keyword);
}
