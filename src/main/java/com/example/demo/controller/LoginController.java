package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.LoginForm;
import com.example.demo.Entity.Account;
import com.example.demo.service.AccountService;

@Controller
public class LoginController {
	
	@Autowired
	AccountService service;
	
	public LoginController(AccountService service) {
		this.service = service;
	}
	
	@RequestMapping("/login")
	public String login(Model model,LoginForm form) {
		return "login";
	}
	
	@RequestMapping("/mypage")
	public String mypage(@Validated LoginForm form, BindingResult result,Model model) {
		if(result.hasErrors()) {
			return "login";
		}
		Account ac = service.login(form.getEmail());
		boolean error = service.logincheck(ac, form.getPassword(), model);
		if(error) {
			return "login";
		}
		model.addAttribute("account", ac);
		return "mypage";
	}
}
