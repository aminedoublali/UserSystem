//WebControllerへ統合

/*package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import com.example.demo.Entity.Account;
import com.example.demo.dao.AccountDao;
import com.example.demo.service.AccountService;

public class list {
//	private final AccountDao accountDao;
//	
//	@Autowired
//	list(AccountDao accountdao) {
//		this.accountDao = accountdao;
//	}
	
	private final AccountService accountService;
	
	@Autowired
	list(AccountService accountService){
		this.accountService = accountService;
	}
	
	public String list(Model model, Account account) {
		List<Account> list = accountService.getAllAccounts();
		model.addAttribute("acList", list);
		return "list";
	}
}
*/