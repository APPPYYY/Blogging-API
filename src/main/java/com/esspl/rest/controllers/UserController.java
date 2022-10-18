package com.esspl.rest.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.esspl.payloads.ApiResponse;
import com.esspl.payloads.UserDto;
import com.esspl.services.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/")
	public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto){
		UserDto createdUser=this.userService.createUser(userDto);
		return new ResponseEntity<>(createdUser,HttpStatus.CREATED);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/{userId}")
	public ResponseEntity<UserDto> updateUser(@Valid @PathVariable("userId") Integer uid,@RequestBody UserDto userDto){
		UserDto updatedUser=this.userService.updateUser(userDto, uid);
		return ResponseEntity.ok(updatedUser);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<UserDto>> findAllUser(){
		return ResponseEntity.ok(this.userService.getAllUser());
	}
	
	@GetMapping("/{userId}")
	public ResponseEntity<UserDto> getById(@PathVariable("userId") Integer uid){
		return ResponseEntity.ok(this.userService.getById(uid));
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/{userId}")
	public ResponseEntity<ApiResponse> deleteUser(@PathVariable("userId") Integer uid){
		this.userService.deleteUser(uid);
		return new ResponseEntity<>(new ApiResponse("__comeflywithme__","User successfully deleted !","Sorry ab kuch nehi"
				+ " kar sakte !!!",true),HttpStatus.OK);
	}
	
	
	
	
	
	
}
