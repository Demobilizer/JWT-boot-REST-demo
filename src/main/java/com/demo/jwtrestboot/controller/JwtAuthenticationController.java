package com.demo.jwtrestboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.jwtrestboot.config.JwtTokenUtil;
import com.demo.jwtrestboot.model.JwtRequest;
import com.demo.jwtrestboot.model.JwtResponse;
import com.demo.jwtrestboot.service.JwtUserDetailService;

@RestController
public class JwtAuthenticationController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private JwtUserDetailService userDetailService;

	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {

		authenticate(authenticationRequest.getUserName(), authenticationRequest.getPassword());
		
		final UserDetails userDetails = userDetailService.loadUserByUsername(authenticationRequest.getUserName());
		final String token = jwtTokenUtil.generateToken(userDetails);
		return ResponseEntity.ok(new JwtResponse(token));
	}

	private void authenticate(String userName, String password) throws Exception {
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userName, password));
	}
}
