package com.kiselev.springbootreglogindemo.web;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kiselev.springbootreglogindemo.service.UserService;
import com.kiselev.springbootreglogindemo.web.dto.UserRegistrationDto;

@Controller
@RequestMapping("/registration")
public class UserRegistrationController {

	private final UserService userService;

	public UserRegistrationController(UserService userService) {
		this.userService = userService;
	}
	
	@ModelAttribute("user")
    public UserRegistrationDto userRegistrationDto() {
        return new UserRegistrationDto();
    }
	
	@GetMapping
	public String showRegistrationForm() {
		return "registration";
	}
	
	@PostMapping
	public String registerUserAccount (@Valid @ModelAttribute("user") UserRegistrationDto registrationDto,
									   BindingResult result,
									   Model model) {
		if (userService.findByEmail(registrationDto.getEmail()) != null) {
			result.rejectValue("email", null, "There is already an account registered with that email");
		}
		if (result.hasErrors()) {
			model.addAttribute("user", registrationDto);
			return "registration";
		}
		userService.save(registrationDto);
		return "redirect:/registration?success";
	}
}
