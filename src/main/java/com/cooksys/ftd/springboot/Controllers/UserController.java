package com.cooksys.ftd.springboot.Controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cooksys.ftd.springboot.DTOs.CredentialsDto;
import com.cooksys.ftd.springboot.Entities.Tweet;
import com.cooksys.ftd.springboot.Entities.User;
import com.cooksys.ftd.springboot.RequestDtos.ProfileCredentialsDto;
import com.cooksys.ftd.springboot.Services.UserService;

@RestController
@RequestMapping("users")
public class UserController {

	private UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping
	public List<User> getUsers() {
		return this.userService.getUsers();
	}

	@PostMapping
	public User postUser(@RequestBody ProfileCredentialsDto profileCredentialsDto) {
		return this.userService.postUser(profileCredentialsDto);
	}

	@GetMapping("/@{username}")
	public User getUser(@PathVariable("username") String username) {
		return this.userService.getUser(username);
	}

	@PatchMapping("/@{username}")
	public User updateProfile(@PathVariable("username") String username,
			@RequestBody ProfileCredentialsDto profileCredentialsDto) {
		return this.userService.updateProfile(username, profileCredentialsDto);
	}

	@DeleteMapping("/@{username}")
	public User deleteUser(@PathVariable("username") String username, @RequestBody CredentialsDto credentialsDto) {
		return this.userService.deleteUser(username, credentialsDto);
	}

	@PostMapping("/@{username}/follow")
	public void followUser(@PathVariable("username") String username, @RequestBody CredentialsDto credentialsDto) {
		this.userService.followUser(username, credentialsDto);
	}

	@PostMapping("/@{username}/unfollow")
	public void unfollowUser(@PathVariable("username") String username, @RequestBody CredentialsDto credentialsDto) {
		this.userService.unfollowUser(username, credentialsDto);
	}

	@GetMapping("/@{username}/feed")
	public List<Tweet> getFeed(@PathVariable("username") String username) {
		return this.userService.getFeed(username);
	}

	@GetMapping("/@{username}/tweets")
	public List<Tweet> getTweets(@PathVariable("username") String username) {
		return this.userService.getTweets(username);
	}

	@GetMapping("/@{username}/mentions")
	public List<Tweet> getMentions(@PathVariable("username") String username) {
		return this.userService.getMentions(username);
	}

	@GetMapping("/@{username}/followers")
	public List<User> getFollowers(@PathVariable("username") String username) {
		return this.userService.getFollowers(username);
	}

	@GetMapping("/@{username}/following")
	public List<User> getFollowing(@PathVariable("username") String username) {
		return this.userService.getFollowing(username);
	}

}
