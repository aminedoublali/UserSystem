package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import com.example.demo.Entity.Account;
import com.example.demo.dao.AccountDao;

public class list {
	private final AccountDao accountDao;

	@Autowired
	list(AccountDao accountdao) {
		this.accountDao = accountdao;
	}

	public String list(Model model, Account account) {
		List<Account> list = accountDao.findAll();
		model.addAttribute("acList", list);
		return "list";
	}
}
