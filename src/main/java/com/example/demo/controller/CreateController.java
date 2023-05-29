package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.CreateForm;

@Controller
public class CreateController {

	@RequestMapping("/create")
	public String create(Model model,CreateForm createForm) {
		model.addAttribute("title", "登録ページ");
		return "create";
	}
	
	@RequestMapping("/create/complete")
	public String createComplete(Model model,@Validated CreateForm createForm, BindingResult result) {
		if (result.hasErrors()) {
			model.addAttribute("title", "登録ページ");
			return "create";
		}
		return "complete";
	}
}
