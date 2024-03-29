package com.dayliv.dayliv.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.dayliv.dayliv.validator.PasswordMatches;

import lombok.Data;

@Data
@PasswordMatches
public class SignUpRequest {

	private Long userID;

	private String providerUserId;

	@NotEmpty
	private String displayName;
	@NotEmpty
	private String num_tel;
	@NotEmpty
	private String email;

	private SocialProvider socialProvider;

	@Size(min = 6, message = "{Size.userDto.password}")
	private String password;

	@NotEmpty
	private String matchingPassword;

	public SignUpRequest(String providerUserId, String displayName, String email, String password, String num_tel, SocialProvider socialProvider) {
		this.providerUserId = providerUserId;
		this.displayName = displayName;
		this.email = email;
		this.num_tel = num_tel;
		this.password = password;
		this.socialProvider = socialProvider;
	}

	public static Builder getBuilder() {
		return new Builder();
	}

	public static class Builder {
		private String providerUserID;
		private String displayName;
		private String email;
		private String num_tel;
		private String password;
		private SocialProvider socialProvider;

		public Builder addProviderUserID(final String userID) {
			this.providerUserID = userID;
			
			return this;
		}

		public Builder addDisplayName(final String displayName) {
			this.displayName = displayName;
			return this;
		}

		public Builder addNum_tel(final String num_tel) {
			this.num_tel = num_tel;
			return this;
		}

		public Builder addPassword(final String password) {
			this.password = password;
			return this;
		}

		public Builder addSocialProvider(final SocialProvider socialProvider) {
			this.socialProvider = socialProvider;
			return this;
		}
		
		public Builder addEmail(final String email) {
			this.email = email;
			return this;
		}
	


		public SignUpRequest build() {
			return new SignUpRequest(providerUserID, displayName, email, password,num_tel, socialProvider);
		}
	}
}