package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.Entity.Account;
import com.example.demo.service.AccountService;

@Controller
public class WebController {

	private final AccountService accountService;

	@Autowired
	public WebController(AccountService accountService) {
		this.accountService = accountService;
	}

	@RequestMapping("/")
	public String index(Model model) {
		return "index";
	}

	@RequestMapping("/list")
	public String list(Model model, Account account) {
		List<Account> list = accountService.getAllAccounts();
		model.addAttribute("acList", list);
		return "list";
	}
}
