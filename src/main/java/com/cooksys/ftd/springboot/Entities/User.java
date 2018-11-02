package com.cooksys.ftd.springboot.Entities;

import java.sql.Timestamp;
import java.util.List;
import javax.persistence.*;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id;
	@Embedded
	private Profile profile;
	@Embedded
	private Credentials credentials;
	@Column(updatable = false)
	private Timestamp joined;
	@Column
	private boolean isActive = true;
	@ManyToMany
	private List<User> followers;
	@ManyToMany
	private List<User> following;
	@OneToMany(mappedBy = "author")
	private List<Tweet> tweets;
	
	public User() {}
	
	public User(Profile profile, Timestamp joined) {
		this.profile = profile;
		this.joined = joined;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public Credentials getCredentials() {
		return credentials;
	}

	public void setCredentials(Credentials credentials) {
		this.credentials = credentials;
	}

	public Timestamp getJoined() {
		return joined;
	}

	public void setJoined(Timestamp joined) {
		this.joined = joined;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public List<User> getFollowers() {
		return followers;
	}

	public void setFollowers(List<User> followers) {
		this.followers = followers;
	}
	
	public void addFollowers(User user) {
		this.followers.add(user);
	}
	
	public void removeFollowers(User user) {
		this.followers.remove(user);
	}

	public List<User> getFollowing() {
		return following;
	}

	public void setFollowing(List<User> followering) {
		this.following = followering;
	}
	
	public void addToFollowing(User user) {
		this.following.add(user);
	}
	
	public void removeFromFollowing(User user) {
		this.following.remove(user);
	}

	public List<Tweet> getTweets() {
		return tweets;
	}

	public void setTweets(List<Tweet> tweets) {
		this.tweets = tweets;
	}
	
	

}
