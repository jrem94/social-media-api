package com.cooksys.ftd.springboot.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.cooksys.ftd.springboot.DTOs.CredentialsDto;
import com.cooksys.ftd.springboot.Entities.Tweet;
import com.cooksys.ftd.springboot.Entities.User;
import com.cooksys.ftd.springboot.Mappers.CredentialsDtoMapper;
import com.cooksys.ftd.springboot.Mappers.ProfileCredentialsDtoMapper;
import com.cooksys.ftd.springboot.Repositories.UserRepository;
import com.cooksys.ftd.springboot.RequestDtos.ProfileCredentialsDto;

@Service
public class UserService {

	private UserRepository userRepository;
	private CredentialsDtoMapper credentialsDtoMapper;
	private ProfileCredentialsDtoMapper profileCredentialsDtoMapper;

	public UserService(UserRepository userRepository, CredentialsDtoMapper credentialsDtoMapper,
			ProfileCredentialsDtoMapper profileCredentialsDtoMapper) {
		this.userRepository = userRepository;
		this.credentialsDtoMapper = credentialsDtoMapper;
		this.profileCredentialsDtoMapper = profileCredentialsDtoMapper;
	}

	public List<User> getUsers() {
		return this.userRepository.findAll();
	}

	public User postUser(ProfileCredentialsDto profileCredentialsDto) {
		return this.userRepository.save(this.profileCredentialsDtoMapper.dtoToUser(profileCredentialsDto));
	}

	public User getUser(String username) {
		Integer userId = null;
		List<User> users = getUsers();
		for (User user : users) {
			if (user.getCredentials().getUsername() == username) {
				userId = user.getId();
			}
		}
		return this.userRepository.getOne(userId);
	}

	public User updateProfile(String username, ProfileCredentialsDto profileCredentialsDto) {
		if (username.equals(profileCredentialsDto.getCredentials().getUsername())) {
			User user = getUser(username);
			if (user.getCredentials().getPassword().equals(profileCredentialsDto.getCredentials().getPassword())) {
				user.setProfile(profileCredentialsDto.getProfile());
				return this.userRepository.save(user);
			}
		}
		return null; // throw 400 error
	}

	public User deleteUser(String username, CredentialsDto credentialsDto) {
		User user = getUser(username);
		if (user.getCredentials() == this.credentialsDtoMapper.dtoToUser(credentialsDto).getCredentials()) {
			user.setActive(false);
			this.userRepository.save(user);
		}
		return user;
	}

	public void followUser(String username, CredentialsDto credentialsDto) {
		User target = getUser(username);
		User subscriber = getUser(credentialsDto.getUsername());
		if (subscriber.getCredentials() == this.credentialsDtoMapper.dtoToUser(credentialsDto).getCredentials()) {
			if (!subscriber.getFollowing().contains(target) && target.isActive() == true) {
				target.addFollowers(subscriber);
				this.userRepository.save(target);
				subscriber.addToFollowing(target);
				this.userRepository.save(subscriber);
			}
		}
		// throw 400 error
	}

	public void unfollowUser(String username, CredentialsDto credentialsDto) {
		User target = getUser(username);
		User subscriber = getUser(credentialsDto.getUsername());
		if (subscriber.getCredentials().equals(credentialsDto)) {
			if (!subscriber.getFollowing().contains(target) && target.isActive() == true) {
				target.removeFollowers(subscriber);
				;
				this.userRepository.save(target);
				subscriber.removeFromFollowing(target);
				this.userRepository.save(subscriber);
			}
		}
		// throw 400 error
	}

	public List<Tweet> getFeed(String username) {
		if (getUsers().contains(getUser(username)) || getUser(username).isActive()) {
			List<Tweet> feed = new ArrayList<Tweet>();
			User user = getUser(username);
			List<User> following = user.getFollowing();
			for (User follow : following) {
				List<Tweet> tweets = follow.getTweets();
				for (Tweet tweet : tweets) {
					feed.add(tweet);
				}
			}
			return feed;
		}
		return null; // throw 400 error
	}

	public List<Tweet> getTweets(String username) {
		if (getUsers().contains(getUser(username)) || getUser(username).isActive()) {
			User user = getUser(username);
			return user.getTweets(); // needs to be in reverse chronological order
		}
		return null; // throw 400 error
	}

	// Add mentions to Tweet
	public List<Tweet> getMentions(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<User> getFollowers(String username) {
		return getUser(username).getFollowers();
	}

	public List<User> getFollowing(String username) {
		return getUser(username).getFollowing();
	}

}
