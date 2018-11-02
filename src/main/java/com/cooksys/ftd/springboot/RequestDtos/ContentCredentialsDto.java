package com.cooksys.ftd.springboot.RequestDtos;

import com.cooksys.ftd.springboot.Entities.Credentials;

public class ContentCredentialsDto {

	private String content;
	private Credentials credentials;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Credentials getCredentials() {
		return credentials;
	}

	public void setCredentials(Credentials credentials) {
		this.credentials = credentials;
	}

}
