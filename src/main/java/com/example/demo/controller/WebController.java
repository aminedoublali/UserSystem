package com.example.demo.controller;

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
	
	@RequestMapping("/list")
	public String list(Model model) {
		return "list";
	}
}
