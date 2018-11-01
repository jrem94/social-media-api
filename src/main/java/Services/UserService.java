package Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import DTOs.CredentialsDto;
import Entities.User;
import Interfaces.Tweet;
import Mappers.CredentialsDtoMapper;
import Mappers.ProfileCredentialsDtoMapper;
import Mappers.UserDtoMapper;
import Repositories.UserRepository;
import RequestDtos.ProfileCredentialsDto;

@Service
public class UserService {

	private UserRepository userRepository;
	private UserDtoMapper userDtoMapper;
	private CredentialsDtoMapper credentialsDtoMapper;
	private ProfileCredentialsDtoMapper profileCredentialsDtoMapper;
	
	public UserService(UserRepository userRepository, UserDtoMapper userDtoMapper,
			CredentialsDtoMapper credentialsDtoMapper, ProfileCredentialsDtoMapper profileCredentialsDtoMapper) {
		this.userRepository = userRepository;
		this.userDtoMapper = userDtoMapper;
		this.credentialsDtoMapper = credentialsDtoMapper;
		this.profileCredentialsDtoMapper = profileCredentialsDtoMapper;
	}
	
	public List<User> getUsers() {
		List<User> users = new ArrayList<User>();
		users = this.userRepository.findAll();
		return users;
	}

	public User postUser(ProfileCredentialsDto profileCredentialsDto) {
		return this.userRepository.save(this.profileCredentialsDtoMapper.dtoToUser(profileCredentialsDto));
	}

	public User getUser(String username) {
		Integer userId = null;
		List<User> users = getUsers();
		for(User user : users) {
			if(user.getUsername() == username) {
				userId = user.getId();
			}
		}
		return this.userRepository.getOne(userId);
	}

	//check logic
	public User updateProfile(String username, ProfileCredentialsDto profileCredentialsDto) {
		User user = getUser(username);
		user.setCredentials(profileCredentialsDto.getCredentials());
		user.setProfile(profileCredentialsDto.getProfile());
		return this.userRepository.save(user);
	}

	//check logic
	public User deleteUser(String username, CredentialsDto credentialsDto) {
		User user = getUser(username);
		User priorToDeletion = user;
		if(user.getCredentials() == this.credentialsDtoMapper.dtoToUser(credentialsDto).getCredentials()) {
			user.setActive(false);
			this.userRepository.save(user);
		}
		return priorToDeletion;
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
