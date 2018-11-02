package com.cooksys.ftd.springboot.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cooksys.ftd.springboot.Services.ValidateService;

@RestController
@RequestMapping("validate")
public class ValidateController {

	private ValidateService validateService;
	
	public ValidateController(ValidateService validateService) {
		this.validateService = validateService;
	}
	
	@GetMapping("/tag/exists/{label}")
	public boolean tagExists(@PathVariable("label") String label) {
		return this.validateService.tagExists(label);
	}
	
	@GetMapping("/username/exists/@{username}")
	public boolean usernameExists(@PathVariable("username") String username) {
		return this.validateService.usernameExists(username);
	}
	
	@GetMapping("/username/available/@{username}")
	public boolean usernameAvailable(@PathVariable("username") String username) {
		return this.validateService.usernameAvailable(username);
	}
	
}
