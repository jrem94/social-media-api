package com.cooksys.ftd.springboot.RequestDtos;

import com.cooksys.ftd.springboot.Entities.Credentials;
import com.cooksys.ftd.springboot.Entities.Profile;

public class ProfileCredentialsDto {

	private Credentials credentials;
	private Profile profile;

	public Credentials getCredentials() {
		return credentials;
	}

	public void setCredentials(Credentials credentials) {
		this.credentials = credentials;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

}
