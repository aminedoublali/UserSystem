package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.CreateForm;
import com.example.demo.dao.AccountDao;
import com.example.demo.service.AccountService;

@Controller
public class CreateController {

	@RequestMapping("/create")
	public String create(Model model,CreateForm createForm) {
		model.addAttribute("title", "登録ページ");
		return "create";
	}
	@Autowired
	private final AccountDao accountdao;
	@Autowired
	private final AccountService accountservice;
    public CreateController(AccountDao accountdao,AccountService accountservice) {
        this.accountdao = accountdao;
        this.accountservice = accountservice;
    }

	@RequestMapping("/create/complete")
	public String createComplete(Model model,@Validated CreateForm createForm, BindingResult result) {
		if (result.hasErrors()) {
			model.addAttribute("title", "登録ページ");
			return "create";
		}
		boolean cmpflg = accountservice.signup(createForm.getName(), createForm.getEmail(),createForm.getPassword(),createForm.getAddress(), model);
		if(cmpflg) {
			model.addAttribute("title", "登録ページ");
			return "create";
		}
		model.addAttribute("account", accountdao.findByEmail(createForm.getEmail()));
		model.addAttribute("title", "登録完了(仮)");
		return "complete";
	}
}
