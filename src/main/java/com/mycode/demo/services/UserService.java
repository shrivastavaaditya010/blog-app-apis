package com.mycode.demo.services;

import java.util.List;

import com.mycode.demo.entities.User;
import com.mycode.demo.payloads.UserDto;

public interface UserService {

	UserDto createUser(UserDto user);

	UserDto updateUser(UserDto user, Integer userId);

	UserDto getUserById(Integer userId);

	List<UserDto> getAllUsers();

	void deleteUser(Integer userId);
}
