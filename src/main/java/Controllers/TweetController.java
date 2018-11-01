package Controllers;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.*;

import DTOs.CredentialsDto;
import Entities.Context;
import Entities.Hashtag;
import Entities.ReplyTweet;
import Entities.RepostTweet;
import Entities.SimpleTweet;
import Entities.User;
import Interfaces.Tweet;
import RequestDtos.ContentCredentialsDto;
import Services.TweetService;

@RestController
@RequestMapping("tweets")
public class TweetController {

	private TweetService tweetService;
	
	public TweetController(TweetService tweetService) {
		this.tweetService = tweetService;
	}
	
	@GetMapping
	public ArrayList<Tweet> getTweets(){
		return this.tweetService.getTweets();
	}
	
	@PostMapping
	public SimpleTweet postTweets(@RequestBody ContentCredentialsDto contentCredentialsDto){
		return this.tweetService.postTweets(contentCredentialsDto);
	}
	
	@GetMapping("/{id}")
	public Tweet getTweetById(@PathVariable("id") Integer id) {
		return this.tweetService.getTweetById(id);
	}
	
	@DeleteMapping("/{id}")
	public Tweet deleteTweetById(@PathVariable("id") Integer id, @RequestBody CredentialsDto credentialsDto) {
		return this.tweetService.deleteTweetById(id, credentialsDto);
	}
	
	@PostMapping("/{id}/like")
	public void likeTweetById(@PathVariable("id") Integer id, @RequestBody CredentialsDto credentialsDto) {
		this.tweetService.likeTweetById(id, credentialsDto);
	}
	
	@PostMapping("/{id}/reply")
	public ReplyTweet replyToTweetById(@PathVariable("id") Integer id, @RequestBody ContentCredentialsDto contentCredentialsDto) {
		return this.tweetService.replyToTweetById(id, contentCredentialsDto);
	}
	
	@PostMapping("/{id}/repost")
	public RepostTweet repostTweetById(@PathVariable("id") Integer id, @RequestBody CredentialsDto credentialsDto) {
		return this.tweetService.repostTweetById(id, credentialsDto);
	}
	
	@GetMapping("/{id}/tags")
	public ArrayList<Hashtag> getTagsByTweetId(@PathVariable("id") Integer id){
		return this.tweetService.getTagsByTweetId(id);
	}
	
	@GetMapping("/{id}/likes")
	public ArrayList<User> getUsersByLikedTweetId(@PathVariable("id") Integer id){
		return this.tweetService.getUsersByLikedTweetId(id);
	}
	
	@GetMapping("/{id}/context")
	public Context getContextByTweetId() {
		return this.tweetService.getContextByTweetId();
	}
	
	@GetMapping("/{id}/replies")
	public ArrayList<Tweet> getRepliesByTweetId(@PathVariable("id") Integer id){
		return this.tweetService.getRepliesByTweetId(id);
	}
	
	@GetMapping("/{id}/reposts")
	public ArrayList<Tweet> getRepostsByTweetId(@PathVariable("id") Integer id){
		return this.tweetService.getRepostsByTweetId(id);
	}
	
	@GetMapping("/{id}/mentions")
	public ArrayList<User> getMentionedUsersByTweetId(@PathVariable("id") Integer id){
		return this.tweetService.getMentionedUsersByTweetId(id);
	}

}
