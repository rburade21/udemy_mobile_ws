package com.example.demo.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.UserEntity;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import com.example.demo.ui.model.shared.dto.UserDto;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDto createUser(UserDto user) {
	
		if(userRepository.findUserByEmail(user.getEmail())!=null)
			throw new RuntimeException("User already exists"); 		
		UserEntity userEntity=new UserEntity();
		BeanUtils.copyProperties(user, userEntity);
		userEntity.setUserId("userId");
		userEntity.setEncryptedPassword("encryptedPassword");
		UserEntity entity=userRepository.save(userEntity);
		UserDto dto=new UserDto();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

}
