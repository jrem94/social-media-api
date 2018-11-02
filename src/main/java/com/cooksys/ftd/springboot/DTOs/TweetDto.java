package com.cooksys.ftd.springboot.DTOs;

import java.sql.Timestamp;

import com.cooksys.ftd.springboot.Entities.User;

public class TweetDto {

	private User author;
	private Timestamp posted;
	private String content;
	private boolean isNotDeleted;

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	public Timestamp getPosted() {
		return posted;
	}

	public void setPosted(Timestamp posted) {
		this.posted = posted;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public boolean isNotDeleted() {
		return isNotDeleted;
	}

	public void setNotDeleted(boolean isNotDeleted) {
		this.isNotDeleted = isNotDeleted;
	}

}
