package Services;

import java.util.ArrayList;
import org.springframework.stereotype.*;

import DTOs.CredentialsDto;
import Entities.User;
import Interfaces.Tweet;
import RequestDtos.ProfileCredentialsDto;

@Service
public class UserService {

	public ArrayList<User> getUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	public User postUser(ProfileCredentialsDto profileCredentialsDto) {
		// TODO Auto-generated method stub
		return null;
	}

	public User getUser(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	public User updateProfile(String username, ProfileCredentialsDto profileCredentialsDto) {
		// TODO Auto-generated method stub
		return null;
	}

	public User deleteUser(String username, CredentialsDto credentialsDto) {
		// TODO Auto-generated method stub
		return null;
	}

	public void followUser(String username, CredentialsDto credentialsDto) {
		// TODO Auto-generated method stub
		
	}

	public void unfollowUser(String username, CredentialsDto credentialsDto) {
		// TODO Auto-generated method stub
		
	}

	public ArrayList<Tweet> getFeed(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<Tweet> getTweets(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<Tweet> getMentions(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<User> getFollowers(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<User> getFollowing(String username) {
		// TODO Auto-generated method stub
		return null;
	}

}
