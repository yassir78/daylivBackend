package com.dayliv.dayliv.dto;

import java.util.List;

import com.dayliv.dayliv.model.User;

import lombok.Value;

@Value
public class UserInfo {
	private String id, displayName, email,storeCode, nom, prenom,image_profile, num_tel ;
	//private User user;
	private List<String> roles;
}