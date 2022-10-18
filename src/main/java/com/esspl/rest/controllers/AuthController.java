package com.esspl.rest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.esspl.exceptions.ApiException;
import com.esspl.payloads.JwtAuthRequest;
import com.esspl.payloads.JwtAuthResponse;
import com.esspl.payloads.UserDto;
import com.esspl.security.JwtTokenHelper;
import com.esspl.services.UserService;

@RestController
@RequestMapping("/api/v1/auth/")
public class AuthController {

	@Autowired
	private JwtTokenHelper jwtTokenHelper;
	@Autowired
	private UserDetailsService userDetailsService;
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private UserService userService;
	
	
	
	@PostMapping("/login")
	public ResponseEntity<JwtAuthResponse> createToken(
			@RequestBody JwtAuthRequest request
			) throws Exception{
		
		this.authenticate(request.getUsername(),request.getPassword());
		
		UserDetails userDetails=this.userDetailsService.loadUserByUsername(request.getUsername());
		
		String token=this.jwtTokenHelper.generateToken(userDetails);
		
		JwtAuthResponse response=new JwtAuthResponse();
		response.setToken(token);
		
		
		return new ResponseEntity<>(response,HttpStatus.OK);
	}



	private void authenticate(String username, String password) throws Exception {
		
		UsernamePasswordAuthenticationToken authenticationToken=new UsernamePasswordAuthenticationToken(username, password);
		
		try {
			this.authenticationManager.authenticate(authenticationToken);
			
		} catch (BadCredentialsException e) {
			
			System.out.println("Invalid Credentials !!!");
			throw new ApiException("Invalid username or password !!!");
		}
		
	}
	
	
	
	@PostMapping("/register")
	public ResponseEntity<UserDto> registerUser(@RequestBody UserDto userDto){
		UserDto registeredUser=this.userService.registerUser(userDto);
		return new ResponseEntity<>(registeredUser,HttpStatus.CREATED);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
