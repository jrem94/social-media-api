package Services;

import java.util.ArrayList;

import DTOs.CredentialsDto;
import Entities.Context;
import Entities.Credentials;
import Entities.Hashtag;
import Entities.ReplyTweet;
import Entities.RepostTweet;
import Entities.SimpleTweet;
import Entities.User;
import Interfaces.Tweet;
import RequestDtos.ContentCredentialsDto;

public class TweetService {

	public ArrayList<Tweet> getTweets() {
		// TODO Auto-generated method stub
		return null;
	}

	public SimpleTweet postTweets(ContentCredentialsDto contentCredentialsDto) {
		// TODO Auto-generated method stub
		return null;
	}

	public Tweet getTweetById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	public Tweet deleteTweetById(Integer id, CredentialsDto credentialsDto) {
		// TODO Auto-generated method stub
		return null;
	}

	public void likeTweetById(Integer id, CredentialsDto credentialsDto) {
		// TODO Auto-generated method stub
		
	}

	public ReplyTweet replyWithTweet(Integer id, String content, Credentials credentials) {
		// TODO Auto-generated method stub
		return null;
	}

	public RepostTweet repostTweetById(Integer id, CredentialsDto credentialsDto) {
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

	public ReplyTweet replyToTweetById(Integer id, ContentCredentialsDto contentCredentialsDto) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
