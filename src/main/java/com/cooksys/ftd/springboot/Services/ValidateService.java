package com.cooksys.ftd.springboot.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cooksys.ftd.springboot.Entities.User;
import com.cooksys.ftd.springboot.Repositories.UserRepository;

@Service
public class ValidateService {

	private UserRepository userReposity;

	public boolean tagExists(String label) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean usernameExists(String username) {
		List<User> users = userReposity.findAll();
		for (User user : users) {
			if (user.getCredentials().getUsername() == username) {
				return true;
			}
		}
		return false;
	}

	public boolean usernameAvailable(String username) {
		if (usernameExists(username) == false) {
			return true;
		}
		return false;
	}

}
