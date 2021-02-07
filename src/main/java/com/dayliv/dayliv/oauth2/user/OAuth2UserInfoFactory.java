package com.dayliv.dayliv.oauth2.user;

import java.util.Map;

import com.dayliv.dayliv.dto.SocialProvider;
import com.dayliv.dayliv.exception.OAuth2AuthenticationProcessingException;

public class OAuth2UserInfoFactory {
	public static OAuth2UserInfo getOAuth2UserInfo(String registrationId, Map<String, Object> attributes) {
		if (registrationId.equalsIgnoreCase(SocialProvider.GOOGLE.getProviderType())) {
			return new GoogleOAuth2UserInfo(attributes);
		} else if (registrationId.equalsIgnoreCase(SocialProvider.FACEBOOK.getProviderType())) {
			return new FacebookOAuth2UserInfo(attributes);
		}else {
			throw new OAuth2AuthenticationProcessingException("Sorry! Login with " + registrationId + " is not supported yet.");
		}
	}
}