package com.cooksys.ftd.springboot.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.cooksys.ftd.springboot.DTOs.CredentialsDto;
import com.cooksys.ftd.springboot.Entities.Context;
import com.cooksys.ftd.springboot.Entities.Credentials;
import com.cooksys.ftd.springboot.Entities.Hashtag;
import com.cooksys.ftd.springboot.Entities.Tweet;
import com.cooksys.ftd.springboot.Entities.User;
import com.cooksys.ftd.springboot.Mappers.ContentCredentialsDtoMapper;
import com.cooksys.ftd.springboot.Mappers.CredentialsDtoMapper;
import com.cooksys.ftd.springboot.Repositories.TweetRepository;
import com.cooksys.ftd.springboot.Repositories.UserRepository;
import com.cooksys.ftd.springboot.RequestDtos.ContentCredentialsDto;

@Service
public class TweetService {
	
	private TweetRepository tweetRepository;
	private UserRepository userRepository;
	private ContentCredentialsDtoMapper contentCredentialsDtoMapper;
	private CredentialsDtoMapper credentialsDtoMapper;
	
	

	public TweetService(TweetRepository tweetRepository, UserRepository userRepository,
			ContentCredentialsDtoMapper contentCredentialsDtoMapper, CredentialsDtoMapper credentialsDtoMapper) {
		this.tweetRepository = tweetRepository;
		this.userRepository = userRepository;
		this.contentCredentialsDtoMapper = contentCredentialsDtoMapper;
		this.credentialsDtoMapper = credentialsDtoMapper;
	}

	//Get all non-deleted tweets in reverse chronological order.
	public List<Tweet> getTweets() {
		return this.tweetRepository.findAll();
	}

	public Tweet postTweets(ContentCredentialsDto contentCredentialsDto) {
		Tweet tweet = new Tweet();
		List<User> users = this.userRepository.findAll();
		for(User user : users) {
			if(user.getCredentials().equals(contentCredentialsDto.getCredentials())) {
				tweet.setAuthor(user);
				tweet.setContent(contentCredentialsDto.getContent());
				return this.tweetRepository.save(tweet);
			}
		}
		return null; //throw 400 error
	}

	public Tweet getTweetById(Integer id) {
		List<Tweet> tweets = getTweets();
		for(Tweet tweet : tweets) {
			if(tweet.getId() == id) {
				return tweet;
			}
		}
		return null; //throw 400 error
	}

	public Tweet deleteTweetById(Integer id, CredentialsDto credentialsDto) {
		Tweet tweet = getTweetById(id);
		if(tweet.getAuthor().getCredentials().equals(credentialsDtoMapper.dtoToUser(credentialsDto))) {
			tweet.setNotDeleted(false);
			return this.tweetRepository.save(tweet);
		}
		return null; //throw 400 error
	}

	public void likeTweetById(Integer id, CredentialsDto credentialsDto) {
		Tweet tweet = getTweetById(id);
		if(tweet.getAuthor().getCredentials().equals(credentialsDtoMapper.dtoToUser(credentialsDto))) {
			//TODO implement like relationship in Tweet.
		}
	}

	public Tweet replyWithTweet(Integer id, String content, Credentials credentials) {
		return null;
	}

	public Tweet repostTweetById(Integer id, CredentialsDto credentialsDto) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<Hashtag> getTagsByTweetId(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<User> getUsersByLikedTweetId(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	public Context getContextByTweetId() {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<Tweet> getRepliesByTweetId(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<Tweet> getRepostsByTweetId(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<User> getMentionedUsersByTweetId(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	public Tweet replyToTweetById(Integer id, ContentCredentialsDto contentCredentialsDto) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
