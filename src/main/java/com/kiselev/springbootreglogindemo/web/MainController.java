package com.kiselev.springbootreglogindemo.web;

import com.kiselev.springbootreglogindemo.service.UserService;
import com.kiselev.springbootreglogindemo.web.dto.UserRegistrationDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MainController {

	private final UserService userService;

	public MainController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/")
	public String home() {
		return "index";
	}

	@GetMapping("/users")
	public String listRegisteredUsers(Model model){
		List<UserRegistrationDto> users = userService.findAllUsers();
		model.addAttribute("users", users);
		return "users";
	}
}
