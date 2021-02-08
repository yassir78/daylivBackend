package com.dayliv.dayliv.dto;

import com.dayliv.dayliv.model.User;

import lombok.Value;

@Value
public class JwtAuthenticationResponse {
	private String accessToken;
	//private UserInfo user;
	private User user;
}