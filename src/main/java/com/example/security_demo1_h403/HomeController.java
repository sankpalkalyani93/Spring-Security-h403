package com.example.security_demo1_h403;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/public")
	public String publicPage(Model model) {
		
		model.addAttribute("message", "Welcome to the Public Page.");
		return "public";
	}
	
	@GetMapping("/secure")
	public String securePage(Model model) {
		
		model.addAttribute("message", "Welcome to the Secure Page.");
		return "secure";
	}
	
	@GetMapping("/login")
	public String loginPage() {
		
		return "login";
	}
}
