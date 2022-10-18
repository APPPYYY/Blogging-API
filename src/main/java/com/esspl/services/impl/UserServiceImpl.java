package com.esspl.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.esspl.config.AppConstants;
import com.esspl.exceptions.ResourceNotFoundException;
import com.esspl.models.Role;
import com.esspl.models.User;
import com.esspl.payloads.UserDto;
import com.esspl.repositories.RoleRepo;
import com.esspl.repositories.UserRepo;
import com.esspl.services.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepo userRepo;
	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private RoleRepo roleRepo;
	

	@Override
	public UserDto createUser(UserDto userDto) {
		User user=this.dtoToUser(userDto);
		User savedUser=this.userRepo.save(user);
		return this.userToDto(savedUser);
	}

	@Override
	public UserDto updateUser(UserDto userDto, Integer userId) {
		User user=this.userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User","Id",userId));
		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		user.setAbout(userDto.getAbout());
		User updatedUser=this.userRepo.save(user);
		return this.userToDto(updatedUser);
		
	}

	@Override
	public UserDto getById(Integer userId) {
		
		User user=this.userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User","Id",userId));
		return this.userToDto(user);
	}

	@Override
	public void deleteUser(Integer userId) {
		User user=this.userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User","Id",userId));
		 this.userRepo.delete(user);

	}

	@Override
	public List<UserDto> getAllUser() {
		
		List<User> users=this.userRepo.findAll();
		return users.stream().map(user->this.userToDto(user)).collect(Collectors.toList());
		
		
	}
	
	
	
	public User dtoToUser(UserDto userDto) {
		User user=modelMapper.map(userDto, User.class);
		/*
		 * user.setId(userDto.getId()); user.setName(userDto.getName());
		 * user.setEmail(userDto.getEmail()); user.setPassword(userDto.getPassword());
		 * user.setAbout(userDto.getAbout());
		 */
		return user;
	}
	
	public UserDto userToDto(User user) {
		UserDto userDto=modelMapper.map(user, UserDto.class);
		/*
		 * userDto.setId(user.getId()); userDto.setName(user.getName());
		 * userDto.setEmail(user.getEmail()); userDto.setPassword(user.getPassword());
		 * userDto.setAbout(user.getAbout());
		 */
		return userDto;
	}

	@Override
	public UserDto registerUser(UserDto userDto) {
		
		User user=this.modelMapper.map(userDto,User.class);
		user.setPassword(this.passwordEncoder.encode(userDto.getPassword()));
		Role role=this.roleRepo.findById(AppConstants.ROLE_NORMAL).get();
	    user.getRoles().add(role);
	    
	    User registeredUser=this.userRepo.save(user);
		
		
		return this.modelMapper.map(registeredUser, UserDto.class);
	}
	
	
	
	
	
	

}
