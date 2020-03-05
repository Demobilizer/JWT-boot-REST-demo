package com.demo.jwtrestboot.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailService implements UserDetailsService {
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	//private String passwordEncoded = "a";

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		if ("a".equals(username)) {
			return new User("a", passwordEncoder.encode("a"), new ArrayList<>());
		} else {
			throw new UsernameNotFoundException("user not found with username: " + username);
		}
	}

}
