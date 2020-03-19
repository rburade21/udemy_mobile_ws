package com.example.demo.ui.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.UserService;
import com.example.demo.ui.model.UserDetailsRequestModel;
import com.example.demo.ui.model.UserRest;
import com.example.demo.ui.model.shared.dto.UserDto;

@RestController
@RequestMapping("users")
public class UserController {

	@Autowired
	UserService userService;
	
	@GetMapping
	public String getUser()
	{
		return "getUser() was called";
	}	
	
	@PostMapping
	public UserRest createUser(@RequestBody UserDetailsRequestModel  userDetailsRequestModel)
	{
		
		UserRest userRest=new UserRest();
		UserDto userDto=new UserDto();
		BeanUtils.copyProperties(userDetailsRequestModel, userDto);
		UserDto createdUser=userService.createUser(userDto);
		BeanUtils.copyProperties(createdUser, userRest);
		return userRest;
	}
	
	@PutMapping
	public String updateUser()
	{
		return "updateUser() was called";
	}

	@DeleteMapping
	public String deleteUser()
	{
		return "deleteUser() was called";
	}

}
