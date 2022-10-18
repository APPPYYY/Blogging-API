package com.esspl.services;

import java.util.List;

import com.esspl.payloads.UserDto;

public interface UserService {

	UserDto registerUser(UserDto userDto);
	UserDto createUser(UserDto userDto);
	UserDto updateUser(UserDto userDto,Integer userId);
	UserDto getById(Integer userId);
	void deleteUser(Integer userId);
	List<UserDto> getAllUser(); 
}
