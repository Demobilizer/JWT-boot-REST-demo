package com.demo.jwtrestboot.model;

import java.io.Serializable;

public class JwtResponse implements Serializable {

	private static final long serialVersionUID = -798969226231016904L;
	
	private final String jwtToken;

	public JwtResponse(String jwtToken) {
		this.jwtToken = jwtToken;
	}

	public String getJwtToken() {
		return jwtToken;
	}
	
}
