package Controllers;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.*;

import Entities.Hashtag;
import Interfaces.Tweet;
import Services.TagService;

@RestController
@RequestMapping("tags")
public class TagController {

	private TagService tagService;
	
	public TagController(TagService tagService) {
		this.tagService = tagService;
	}
	
	@GetMapping
	public ArrayList<Hashtag> getTags(){
		return this.tagService.getTags();
	}
	
	@GetMapping("/{label}")
	public ArrayList<Tweet> getTweetsByTag(@PathVariable("label") String label){
		return this.tagService.getTweetsByTag(label);
	}
	
}
