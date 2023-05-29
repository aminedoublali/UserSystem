package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebController {

	public WebController() {
		
	}
	
	@RequestMapping("/")
	public String index(Model model) {
		return "index";
	}
	
	@RequestMapping("/create")
	public String create(Model model) {
		return "create";
	}
	
	@RequestMapping("/create/complete")
	public String createComplete(Model model) {
		return "complete";
	}
	
	@RequestMapping("/login")
	public String login(Model model) {
		return "login";
	}
	
	@RequestMapping("/mypage")
	public String loginComplete(Model model) {
		return "mypage";
	}
	
	@RequestMapping("/list")
	public String list(Model model) {
		return "list";
	}
}
