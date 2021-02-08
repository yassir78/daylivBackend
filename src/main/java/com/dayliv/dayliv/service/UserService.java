package com.dayliv.dayliv.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.security.oauth2.core.oidc.OidcIdToken;
import org.springframework.security.oauth2.core.oidc.OidcUserInfo;

import com.dayliv.dayliv.dto.LocalUser;
import com.dayliv.dayliv.dto.SignUpRequest;
import com.dayliv.dayliv.exception.UserAlreadyExistAuthenticationException;
import com.dayliv.dayliv.model.User;

public interface UserService {
	public List<User> findAll();

	public User save(User user);
	
	public User  findByLogin(String login);
    public User findByEmail(String email);
	public void delete(Long id);

	public User update(Long id, User user);

	public User findByNom(String nom);

	public User findById(Long id);

	public User registerNewUser(SignUpRequest signUpRequest) throws UserAlreadyExistAuthenticationException;

	User findUserByEmail(String email);

	Optional<User> findUserById(Long id);

	LocalUser processUserRegistration(String registrationId, Map<String, Object> attributes, OidcIdToken idToken, OidcUserInfo userInfo);
}

