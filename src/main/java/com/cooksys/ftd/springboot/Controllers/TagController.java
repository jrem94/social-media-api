package com.cooksys.ftd.springboot.Controllers;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cooksys.ftd.springboot.Entities.Hashtag;
import com.cooksys.ftd.springboot.Entities.Tweet;
import com.cooksys.ftd.springboot.Services.TagService;

@RestController
@RequestMapping("tags")
public class TagController {

	private TagService tagService;

	public TagController(TagService tagService) {
		this.tagService = tagService;
	}

	@GetMapping
	public ArrayList<Hashtag> getTags() {
		return this.tagService.getTags();
	}

	@GetMapping("/{label}")
	public ArrayList<Tweet> getTweetsByTag(@PathVariable("label") String label) {
		return this.tagService.getTweetsByTag(label);
	}

}
