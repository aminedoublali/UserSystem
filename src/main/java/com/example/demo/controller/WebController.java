package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.Entity.Account;
import com.example.demo.service.AccountService;

@Controller
@RequestMapping("/")
public class WebController {

	private final AccountService accountService;

	@Autowired
	public WebController(AccountService accountService) {
		this.accountService = accountService;
	}

	public String index(Model model) {
		return "index";
	}

	@RequestMapping("list")
	public String list(Model model, Account account) {
		List<Account> list = accountService.getAllAccounts();
		model.addAttribute("acList", list);
		return "list";
	}
	
	@RequestMapping("del/{email}")
	public String del(@PathVariable String email) {
		accountService.deleteaccount(email);
		return "redirect:/list";
	}
}
