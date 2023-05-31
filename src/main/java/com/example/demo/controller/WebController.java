package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.LoginForm;
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

	public String index(Model model, LoginForm form) {
		return "index";
	}

	@RequestMapping("list")
	public String list(Model model, Account account) {
		List<Account> list = accountService.getAllAccounts();
		model.addAttribute("acList", list);
		model.addAttribute("sort", 1);
		return "list";
	}
	
	@RequestMapping("list/{sortId}")
	public String list(@PathVariable Long sortId,Model model, Account account) {
		List<Account> list = null;
		if(sortId == 1) {
			list = accountService.getAllAccountsAscendingId();
		}
		else if(sortId == 2) {
			list = accountService.getAllAccountsDescendingId();
		}
		else if(sortId == 3) {
			list = accountService.getDeletedFalse();
		}
		else if(sortId == 4) {
			list = accountService.getDeletedTrue();
		}
		else {
			list = accountService.getAllAccounts();
		}
		model.addAttribute("acList", list);
		model.addAttribute("sort", sortId);
		return "list";
	}
	
	@RequestMapping("del/{email}")
	public String del(@PathVariable String email) {
		accountService.deleteaccount(email);
		return "redirect:/list";
	}
}
