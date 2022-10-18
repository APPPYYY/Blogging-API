package com.esspl.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.esspl.exceptions.ResourceNotFoundException;
import com.esspl.models.User;
import com.esspl.repositories.UserRepo;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepo userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user=this.userRepo.findByEmail(username).orElseThrow(()->new ResourceNotFoundException("User", "username :"+username, 0));
		
		return user;
	}

}
