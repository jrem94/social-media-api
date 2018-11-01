package Controllers;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.*;

import DTOs.CredentialsDto;
import Entities.User;
import Interfaces.Tweet;
import RequestDtos.ProfileCredentialsDto;
import Services.UserService;

@RestController
@RequestMapping("users")
public class UserController {

	private UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping
	public ArrayList<User> getUsers(){
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
	public User updateProfile(@PathVariable("username") String username, @RequestBody ProfileCredentialsDto profileCredentialsDto) {
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
	public ArrayList<Tweet> getFeed(@PathVariable("username") String username){
		return this.userService.getFeed(username);
	}
	
	@GetMapping("/@{username}/tweets")
	public ArrayList<Tweet> getTweets(@PathVariable("username") String username){
		return this.userService.getTweets(username);
	}
	
	@GetMapping("/@{username}/mentions")
	public ArrayList<Tweet> getMentions(@PathVariable("username") String username){
		return this.userService.getMentions(username);
	}
	
	@GetMapping("/@{username}/followers")
	public ArrayList<User> getFollowers(@PathVariable("username") String username){
		return this.userService.getFollowers(username);
	}
	
	@GetMapping("/@{username}/following")
	public ArrayList<User> getFollowing(@PathVariable("username") String username){
		return this.userService.getFollowing(username);
	}
	
}
