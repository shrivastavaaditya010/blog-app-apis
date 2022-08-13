package com.mycode.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mycode.demo.entities.User;
import com.mycode.demo.exceptions.ResourceNotFoundException;
import com.mycode.demo.repositories.UserRepo;

@Service
public class CustomUserDetailService implements UserDetailsService {

	@Autowired
	private UserRepo userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		// loading user form Database by UserName:
		User user = this.userRepo.findByEmail(username).orElseThrow(()-> new ResourceNotFoundException("user ", "email "+ username, 0));
		return user;
	}

}
