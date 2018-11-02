package com.cooksys.ftd.springboot.Controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cooksys.ftd.springboot.DTOs.CredentialsDto;
import com.cooksys.ftd.springboot.Entities.Context;
import com.cooksys.ftd.springboot.Entities.Hashtag;
import com.cooksys.ftd.springboot.Entities.Tweet;
import com.cooksys.ftd.springboot.Entities.User;
import com.cooksys.ftd.springboot.RequestDtos.ContentCredentialsDto;
import com.cooksys.ftd.springboot.Services.TweetService;

@RestController
@RequestMapping("tweets")
public class TweetController {

	private TweetService tweetService;

	public TweetController(TweetService tweetService) {
		this.tweetService = tweetService;
	}

	@GetMapping
	public List<Tweet> getTweets() {
		return this.tweetService.getTweets();
	}

	@PostMapping
	public Tweet postTweets(@RequestBody ContentCredentialsDto contentCredentialsDto) {
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
	public Tweet replyToTweetById(@PathVariable("id") Integer id,
			@RequestBody ContentCredentialsDto contentCredentialsDto) {
		return this.tweetService.replyToTweetById(id, contentCredentialsDto);
	}

	@PostMapping("/{id}/repost")
	public Tweet repostTweetById(@PathVariable("id") Integer id, @RequestBody CredentialsDto credentialsDto) {
		return this.tweetService.repostTweetById(id, credentialsDto);
	}

	@GetMapping("/{id}/tags")
	public List<Hashtag> getTagsByTweetId(@PathVariable("id") Integer id) {
		return this.tweetService.getTagsByTweetId(id);
	}

	@GetMapping("/{id}/likes")
	public List<User> getUsersByLikedTweetId(@PathVariable("id") Integer id) {
		return this.tweetService.getUsersByLikedTweetId(id);
	}

	@GetMapping("/{id}/context")
	public Context getContextByTweetId() {
		return this.tweetService.getContextByTweetId();
	}

	@GetMapping("/{id}/replies")
	public List<Tweet> getRepliesByTweetId(@PathVariable("id") Integer id) {
		return this.tweetService.getRepliesByTweetId(id);
	}

	@GetMapping("/{id}/reposts")
	public List<Tweet> getRepostsByTweetId(@PathVariable("id") Integer id) {
		return this.tweetService.getRepostsByTweetId(id);
	}

	@GetMapping("/{id}/mentions")
	public List<User> getMentionedUsersByTweetId(@PathVariable("id") Integer id) {
		return this.tweetService.getMentionedUsersByTweetId(id);
	}

}
