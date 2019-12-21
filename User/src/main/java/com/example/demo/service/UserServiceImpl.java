package com.example.demo.service;

import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.model.UserDto;
import com.example.demo.model.UserEntity;
import com.example.demo.repository.UserRepository;
	
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	@Override
	public UserDto createUser(UserDto userDetail) {
		// TODO Auto-generated method stub
		
		userDetail.setUserId(UUID.randomUUID().toString());
		userDetail.setEncryptedPassword(bCryptPasswordEncoder.encode(userDetail.getPassword()));
		ModelMapper modelMapper=new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		UserEntity userEntity=modelMapper.map(userDetail, UserEntity.class);
		//userEntity.setEncryptedPassword("test");
		System.out.println("Before saving to the database");
		userRepository.save(userEntity);
		System.out.println("After Saving the database");
		UserDto userDto=modelMapper.map(userEntity, UserDto.class);
		return userDto;
	}

}
