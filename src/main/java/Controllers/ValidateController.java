package Controllers;

import org.springframework.web.bind.annotation.*;

import Services.ValidateService;

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
