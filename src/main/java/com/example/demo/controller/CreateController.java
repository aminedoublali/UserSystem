package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CreateController {

	@RequestMapping("/create")
	public String create(Model model) {
		return "create";
	}
	
	@RequestMapping("/create/complete")
	public String createComplete(Model model) {
		return "complete";
	}
}
